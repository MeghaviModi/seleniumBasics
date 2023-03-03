package com.envision.openbrowsers.LocatingWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Fb_clickLink_RegPage_Firstname_usingNameLocator {
    @Test
    public void clickLink_regPage_firstname() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        WebDriver cd = new ChromeDriver();
        cd.manage().window().maximize();
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        cd.get("https://www.facebook.com/");
        WebElement createNewAcc=cd.findElement(By.linkText("Create new account"));
        createNewAcc.click();

        WebElement firstnameElement=cd.findElement(By.name("firstname"));
        firstnameElement.clear();
        firstnameElement.sendKeys("Envision");

        WebElement lastnameElement=cd.findElement(By.name("lastname"));
        lastnameElement.clear();
        lastnameElement.sendKeys("Learning");
        //WebElement lastnameElement=cd.findElement(By.cssSelector("input[aria-label='Surname']"));
        Thread.sleep(5000);
        cd.quit();

    }

}
