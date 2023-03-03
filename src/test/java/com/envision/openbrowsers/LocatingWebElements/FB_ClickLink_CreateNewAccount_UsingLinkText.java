package com.envision.openbrowsers.LocatingWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FB_ClickLink_CreateNewAccount_UsingLinkText {
    @Test
    public void clickCreateNewAcc_Link() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        WebDriver cd = new ChromeDriver();
        cd.manage().window().maximize();
        cd.get("https://www.facebook.com/");
        /*By Locate_using_LinkText=By.linkText("Create new account");
        WebElement CreateNewAcc_element=cd.findElement(Locate_using_LinkText);
        CreateNewAcc_element.click();*/
        WebElement CreateNewAcc=cd.findElement(By.linkText("Create new account"));
        CreateNewAcc.click();
        Thread.sleep(5000);
        cd.quit();

    }
}
