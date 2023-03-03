package com.envision.openbrowsers.explicitwait;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class UsingSelectByIndex_ToWait_ToFindList {
    @Test
    public static void selectFB_Dob_data_BYIndex() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        WebDriver cd = new ChromeDriver();
        cd.manage().window().maximize();
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        cd.get("https://www.facebook.com/");
        WebElement createNewAcc = cd.findElement(By.linkText("Create new account"));
        createNewAcc.click();
        List<WebElement> daySelectBoxElement =new WebDriverWait(cd,Duration.ofSeconds(50))
                .ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(5)).
                until(ExpectedConditions.numberOfElementsToBe(By.xpath("//select[@id='day']/option"),31));
        daySelectBoxElement.get(5).click();
    }
}
