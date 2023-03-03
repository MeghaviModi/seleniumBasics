package com.envision.openbrowsers.PracticPrograms;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadResume {
    @Test
    public static void uploadResumeTest() throws AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.monsterindia.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a/span[normalize-space()='Upload Resume']")).click();
       //using SendKeys
        WebElement button=driver.findElement(By.xpath("//input[@id='file-upload']"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", button);
                //.sendKeys("/Users/meghavimodi/Desktop/Resume/MEGHAVIMODI.pdf");

        Robot rb=new Robot();
        rb.delay(2000);

        StringSelection ss=new StringSelection("/Users/meghavimodi/Desktop/Resume/MEGHAVIMODI.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);

        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);


    }
}
