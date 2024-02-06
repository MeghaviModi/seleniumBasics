package com.envision.ProgramsOfJava;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandels {
    @Test
    public void  mywindow() {
        //  WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String allw;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/sql/default.asp");
        String homePage = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@class='w3-example']/a")).click();

        Set<String> allwindows = driver.getWindowHandles();
        for (String all : allwindows) {
            driver.switchTo().window(all);
            allw = driver.getTitle();
            System.out.println(allw);
        }


        driver.close();
        driver.switchTo().window(homePage);
        driver.findElement(By.xpath("//*[@class='w3-clear nextprev']/a[2]")).click();
        System.out.println(driver.getTitle());
        driver.quit();
    }
}

