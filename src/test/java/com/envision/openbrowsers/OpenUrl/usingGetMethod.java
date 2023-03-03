package com.envision.openbrowsers.OpenUrl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class usingGetMethod {
    @Test

    public  void UsingGet() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        WebDriver cd = new ChromeDriver();
        cd.manage().window().maximize();   //rtp
        cd.get("https://www.facebook.com/");//rtp
        Thread.sleep(5000);
        cd.quit();
    }

}
