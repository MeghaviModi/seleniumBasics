package com.envision.openbrowsers.FirefoxT1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxBrowser {
    public static void getFireFoxBrowser() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/meghavimodi/myCode/Downloads/geckodriver");
         WebDriver fd=new FirefoxDriver();
        fd.get("https://www.google.com/");
        fd.manage().window() .maximize();
        Thread.sleep(5000);
        //cd.close();
        fd.quit();
    }
}
class FireFoxBrowserTest{
    public static void main(String[] args) throws InterruptedException {
        FireFoxBrowser.getFireFoxBrowser();
    }
}

