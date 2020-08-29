package com.sos.qa.tests;

import com.sos.qa.base.SOSBase;
import com.sos.qa.pages.SearchPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class searchPageTest extends SOSBase {

    SearchPage searchPage;


    public searchPageTest() {
        super();
    }

    @BeforeSuite
    public void setUp() {

        initialization();
        searchPage = new SearchPage();
    }

    @Test(priority = 1)
    public void searchTest() throws InterruptedException {
        searchPage.search();

    }

    @Test(priority = 2)
    public void nextButtonTest() throws InterruptedException {
        searchPage.nextButton();
    }

    @Test(priority = 3)
    public void ProblemsTest() throws InterruptedException {
        searchPage.problemArea();
    }

    @Test(priority = 4)
    public void solutionTest() throws InterruptedException {
        searchPage.solution();
    }

    @Test(priority = 5)
    public void problems() throws InterruptedException{
        searchPage.problems();
    }

    @Test(priority = 6)
    public void optionalMessage() throws InterruptedException{
        searchPage.optionalMessage();
    }

    @Test(priority = 7)
    public void availabilityTest() throws InterruptedException{
        searchPage.availability();
    }

    @Test(priority = 8)
    public void calendarTest() throws InterruptedException{
        searchPage.calendar();
    }

    @Test(priority = 9)
    public void timingTest() throws InterruptedException{
        searchPage.availableTime();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}

