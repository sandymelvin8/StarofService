package com.sos.qa.base;

import com.sos.qa.util.TimeOuts;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SOSBase {

    public static WebDriver driver;
    public static Properties prop;

    public SOSBase() {
        try {
            prop = new Properties();
            FileInputStream fi = new FileInputStream("C:\\Users\\Melvin\\Desktop\\JavaPrograms\\Star of Service\\" +
                    "src\\main\\java\\com\\sos\\qa\\config\\config.properties");
            prop.load(fi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization(){
        String browserName=prop.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Melvin\\Chrome Driver\\chromedriver.exe");
            driver= new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TimeOuts.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver.manage().timeouts().implicitlyWait(TimeOuts.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }
}