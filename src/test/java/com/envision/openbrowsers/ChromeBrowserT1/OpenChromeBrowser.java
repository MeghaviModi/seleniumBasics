package com.envision.openbrowsers.ChromeBrowserT1;

import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChromeBrowser {
    public static void getChromeBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        ChromeDriver cd=new ChromeDriver();
        cd.get("https://www.google.com/");
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        cd.manage().window() .maximize();
        Thread.sleep(5000);
        cd.close();
        cd.quit();

    }
}
class OpenChromeBrowserTest{
    public static void main(String[] args) throws InterruptedException {
        OpenChromeBrowser.getChromeBrowser();
    }
}