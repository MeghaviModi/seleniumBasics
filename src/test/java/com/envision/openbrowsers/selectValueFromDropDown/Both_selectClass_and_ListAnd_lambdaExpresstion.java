package com.envision.openbrowsers.selectValueFromDropDown;

import org.bouncycastle.crypto.params.TweakableBlockCipherParameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Both_selectClass_and_ListAnd_lambdaExpresstion {
    @Test
    public static void selectFB_Dob_data_BYIndex() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
    WebDriver cd = new ChromeDriver();
        cd.manage().window().maximize();
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        cd.get("https://www.facebook.com/");
    WebElement createNewAcc=cd.findElement(By.linkText("Create new account"));
        createNewAcc.click();
        WebElement daySelectBoxElement2=cd.findElement(By.id("day"));
        Select daySelectBoth=new Select(daySelectBoxElement2);
        daySelectBoth.getOptions().get(11).click();


        new Select(cd.findElement(By.id("month"))).getOptions().stream().filter((month -> month.getText().equalsIgnoreCase("mar"))).findFirst().get().click();
        Thread.sleep(3000);
    cd.quit();
    }

}
