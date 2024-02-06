package com.envision.Java.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
public class BaseTest {
    public WebDriver driver;
    @BeforeMethod

    public void loadBrowser(){
        this.driver=BasePage.lunchBrowser("chrome");
    }
    @AfterMethod
    public void teardownBrowser(){
        driver.quit();
    }



}
