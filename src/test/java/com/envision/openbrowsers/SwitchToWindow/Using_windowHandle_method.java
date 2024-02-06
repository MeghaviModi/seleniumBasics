package com.envision.openbrowsers.SwitchToWindow;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Using_windowHandle_method {
    @Test
    public void Using_windowHandle_methodTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        WebDriver cd = new ChromeDriver();
        cd.manage().window().maximize();
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        cd.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
        String currentPage=cd.getWindowHandle();
        System.out.println(currentPage);

        Thread.sleep(5000);
        cd.switchTo().frame("iframeResult");

        WebElement tryItButton = cd.findElement(By.xpath("//button[text()='Try it']"));
        tryItButton.click();
        WebDriverWait ww=new WebDriverWait(cd, Duration.ofSeconds(50));
        Alert a=ww.pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());
        String readText=a.getText();
        System.out.println(readText);
        a.accept();
        cd.switchTo().window(currentPage);
        WebElement runButton =cd.findElement(By.id("runbtn"));
        runButton.click();
        cd.quit();
    }
}
