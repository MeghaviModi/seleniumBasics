package com.envision.openbrowsers.LocatingWebElements;

import io.cucumber.java.lv.Tad;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.time.Duration;

public class usingFindByAnnotation {
    @FindBy (how = How.XPATH,using ="//input[@name='lastname']")
    WebElement lastname;
    @FindBy (linkText = "Create new account")
    WebElement createNewAcc;
    @Test
    public void enterEmailID() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        WebDriver cd = new ChromeDriver();
        cd.manage().window().maximize();
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        cd.get("https://www.facebook.com/");
        usingFindByAnnotation fb= PageFactory.initElements(cd, usingFindByAnnotation.class);
        fb.createNewAcc.click();
        fb.lastname.clear();
        fb.lastname.sendKeys("Learning");
        Thread.sleep(5000);

        cd.navigate().refresh();

        fb.createNewAcc.click();
        fb.lastname.clear();
        fb.lastname.sendKeys("Envision");
        Thread.sleep(5000);
        cd.quit();
    }

}

