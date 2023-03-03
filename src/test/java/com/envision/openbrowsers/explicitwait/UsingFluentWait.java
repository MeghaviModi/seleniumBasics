package com.envision.openbrowsers.explicitwait;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class UsingFluentWait {
    @Test
    public static void withoutSelect() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        WebDriver cd = new ChromeDriver();
        cd.manage().window().maximize();
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        cd.get("https://www.facebook.com/");
        FluentWait<WebDriver> fw= new WebDriverWait(cd,Duration.ofSeconds(50));
        //fw.withTimeout(Duration.ofSeconds(50));
        fw.pollingEvery(Duration.ofSeconds(5));
        fw.ignoring(StaleElementReferenceException.class);

        WebElement createNewAcc =fw.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Create new account")));
        createNewAcc.click();
        Thread.sleep(3000);
        cd.quit();
    }

}
