package com.envision.openbrowsers.DynamicMenu;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class HandlingDynamicMenuUsingRobot {
    @Test
    public static void HandlingDynamicMenuUsingRobotTest() throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        WebDriver cd = new ChromeDriver();
        cd.get("https://demoqa.com/select-menu");
        cd.manage().window().maximize();
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        Thread.sleep(2000);

        String Xpath = "//div[@id='selectMenuContainer']/div[@class='row'][2]/div/div/div[1]/div";
        WebElement dropDown = cd.findElement(By.xpath(Xpath));
        dropDown.click();
        Thread.sleep(500);

        Actions action=new Actions(cd);
        action.sendKeys(Keys.DOWN).perform();     //selenium keyboard
        Thread.sleep(3000);
        action.sendKeys(Keys.DOWN).perform();
        action.sendKeys(Keys.SPACE).perform();
        Thread.sleep(3000);
        action.sendKeys(Keys.SPACE).perform();
        action.sendKeys(Keys.DOWN).perform();
        action.sendKeys(Keys.SPACE).perform();



        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);

         // I need Return to click
        dropDown.sendKeys(Keys.RETURN);


        //r.keyPress(KeyEvent.VK_ENTER);
        //r.keyRelease(KeyEvent.VK_ENTER);

       // dropDown = cd.findElement(By.xpath(Xpath));
        //dropDown.click();
        Thread.sleep(3000);
        action.contextClick().perform();     // for right click

        Thread.sleep(5000);
        cd.quit();


    }
}
