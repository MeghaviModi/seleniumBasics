package com.envision.openbrowsers.SwitchToAlert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class SwitchToAlert_Normal {
    @Test
    public void switchToAlert_NormalTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        WebDriver cd = new ChromeDriver();
        cd.manage().window().maximize();
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        cd.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
        Thread.sleep(5000);
        cd.switchTo().frame("iframeResult");

        WebElement tryItButton = cd.findElement(By.xpath("//button[text()='Try it']"));
        tryItButton.click();
        Alert a=cd.switchTo().alert();
        String readText=a.getText();
        System.out.println(readText);
        a.accept();
        Thread.sleep(3000);
        cd.quit();

    }

}
