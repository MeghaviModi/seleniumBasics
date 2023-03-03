package com.envision.openbrowsers.SwitchingToFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class SwitchToFrameUsingIndex {
    @Test
    public void switchFrameUsingIndexTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        WebDriver cd = new ChromeDriver();
        cd.manage().window().maximize();
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        cd.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
        Thread.sleep(5000);
        cd.switchTo().frame("iframeResult");

        WebElement tryItButton=cd.findElement(By.xpath("//button[text()='Try it']"));
        tryItButton.click();


    }

}
