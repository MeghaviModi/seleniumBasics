package com.envision.openbrowsers.SwitchingToFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class usingExplicitWait_switchToFrameUsingIndex {
    @Test

    public void switchFrameUsingIndexTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        WebDriver cd = new ChromeDriver();
        cd.manage().window().maximize();
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        cd.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
        Thread.sleep(5000);

        FluentWait<WebDriver> fw=new WebDriverWait(cd,Duration.ofSeconds(50));
        fw.pollingEvery(Duration.ofSeconds(5));
        //fw.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
        fw.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframeResult"));
        WebElement tryItButton=cd.findElement(By.xpath("//button[text()='Try it']"));
        tryItButton.click();
    }

}
