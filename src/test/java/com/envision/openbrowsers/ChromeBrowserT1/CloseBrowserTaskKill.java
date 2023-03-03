package com.envision.openbrowsers.ChromeBrowserT1;

import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.IOException;

public class CloseBrowserTaskKill {
    public static void getChromeBrowser() throws InterruptedException, AWTException, IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        ChromeDriver cd = new ChromeDriver();
        cd.get("https://www.google.com/");
        Thread.sleep(5000);
        Runtime.getRuntime().exec("taskkill/f /im /Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver/t ");
    }


    public static void main(String[] args) throws IOException, InterruptedException, AWTException {
        getChromeBrowser();
    }
}
