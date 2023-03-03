package com.envision.openbrowsers.DynamicMenu;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;


import java.time.Duration;

public class HandlingDynamicMenu {
    @Test
    public static void HandlingDynamicMenuUsingIdTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        WebDriver cd=new ChromeDriver();
        cd.get("https://demoqa.com/select-menu");
        cd.manage().window().maximize();
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        Thread.sleep(2000);

        String Xpath="//div[@id='selectMenuContainer']/div[@class='row'][2]/div/div/div[1]/div[2]";
        WebElement dropDown= cd.findElement(By.xpath(Xpath));


        dropDown.click();

        Thread.sleep(2000);
        WebElement Blue=cd.findElement(By.id("react-select-4-option-1"));
        Blue.click();

        Thread.sleep(2000);
        WebElement black=cd.findElement(By.id("react-select-4-option-2"));
        black.click();

        Thread.sleep(3000);
        cd.quit();



    }
}
