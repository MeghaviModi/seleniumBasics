package com.envision.openbrowsers.OpenUrl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class usingNavigate_ToMethod {
    @Test

    public  void openURL() throws InterruptedException, MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        WebDriver cd = new ChromeDriver();
        cd.manage().window().maximize();   //rtp
        WebDriver.Navigation browserNavigate = cd.navigate();
        browserNavigate.to("https://www.facebook.com/");
        Thread.sleep(5000);
        browserNavigate.to(("https://gmail.com"));
        Thread.sleep(5000);
        browserNavigate.back();
        Thread.sleep(5000);
        browserNavigate.forward();
        Thread.sleep(5000);
        browserNavigate.refresh();

        Thread.sleep(5000);
        cd.quit();
    }
}
