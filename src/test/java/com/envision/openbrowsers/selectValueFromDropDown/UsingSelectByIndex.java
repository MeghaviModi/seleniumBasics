package com.envision.openbrowsers.selectValueFromDropDown;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;

public class UsingSelectByIndex {
    @Test
     public static void selectFB_Dob_data_BYIndex() throws InterruptedException {
         System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
         WebDriver cd = new ChromeDriver();
         cd.manage().window().maximize();
         cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
         cd.get("https://www.facebook.com/");
         WebElement createNewAcc=cd.findElement(By.linkText("Create new account"));
         createNewAcc.click();
         WebElement daySelectBoxElement =cd.findElement(By.id("day"));
         Select daySelect =new Select(daySelectBoxElement);
         daySelect.selectByIndex(5);
         WebElement monthSelectBoxElement =cd.findElement(By.id("month"));
         Select monthSelect =new Select(monthSelectBoxElement);
         monthSelect.selectByVisibleText("Mar");
         WebElement yearSelectBoxElement =cd.findElement(By.id("year"));
         Select yearSelect =new Select(yearSelectBoxElement);
         yearSelect.selectByValue("2014");
        JavascriptExecutor js= (JavascriptExecutor)(cd);
        js.executeScript("window.scrollBY(0,500)");
         Thread.sleep(5000);
         cd.quit();
     }
}
