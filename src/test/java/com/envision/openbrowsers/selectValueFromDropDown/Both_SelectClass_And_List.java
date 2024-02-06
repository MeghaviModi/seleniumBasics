package com.envision.openbrowsers.selectValueFromDropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Both_SelectClass_And_List {
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
        List<WebElement> allDays= daySelect.getOptions();
        System.out.println(allDays.get(3));
        allDays.get(10).click();


        Thread.sleep(300);
        cd.quit();

    }
}
