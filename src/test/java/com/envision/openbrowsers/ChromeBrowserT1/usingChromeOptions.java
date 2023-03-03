package com.envision.openbrowsers.ChromeBrowserT1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class usingChromeOptions {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions co=new ChromeOptions();
        co.addArguments("start-maximized");
        System.setProperty("webdriver.chrome.driver","/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        ChromeDriver cd=new ChromeDriver(co);
        Thread.sleep(5000);
        cd.quit();
    }
}
