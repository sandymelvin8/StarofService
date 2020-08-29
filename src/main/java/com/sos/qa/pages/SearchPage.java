package com.sos.qa.pages;

import com.sos.qa.base.SOSBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchPage extends SOSBase {

    @FindBy(xpath = "//input[@id='postal_code_5f45fb9d34b8b']")
    WebElement searchBar;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    WebElement nextBtn;

    public SearchPage() {
        PageFactory.initElements(driver, this);
    }

    public void search() throws InterruptedException, TimeoutException {
        searchBar.clear();
        searchBar.sendKeys(prop.getProperty("searchtext"));
        Thread.sleep(2000);
        searchBar.sendKeys(Keys.ENTER);
    }

    public void nextButton() throws InterruptedException {
        Thread.sleep(2000);
        nextBtn.click();
    }

    public void problemArea() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'Tap')]")).click();
        nextBtn.click();
    }

    public void solution() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'Replace')]")).click();
        nextBtn.click();
    }

    public void problems() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'Leak in a pipe')]")).click();
        nextBtn.click();
    }

    public void optionalMessage() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@class='text-area__textArea_" +
                "__2N_HC input-text styles__textareaV2___2SDY1']")).sendKeys("Please fix as soon as possible");
        nextBtn.click();
    }

    public void availability() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'On a specific date')]")).click();
        nextBtn.click();
    }

    public void calendar() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> calendarIcon = driver.findElements(By.tagName("td"));
        for(WebElement date: calendarIcon){
            if(date.getText().equalsIgnoreCase(prop.getProperty("availabledate"))){
                date.click();
                break;
            }
        }
        nextBtn.click();
    }

    public void availableTime() throws InterruptedException{
        Thread.sleep(2000);
        Select time=new Select(driver.findElement(By.id("2fb1107f62b7900a8af4942e0a0532a856dd41ed")));
        time.selectByVisibleText(prop.getProperty("availabletime"));
        nextBtn.click();
    }
}

