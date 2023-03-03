package com.envision.openbrowsers.PracticPrograms;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Calendar {
    @Test
    public static void calendarTest() throws InterruptedException {
        String month="March 2019";
        String day="20";
        WebDriverManager.chromedriver().setup();
        WebDriver dr=new ChromeDriver();
        dr.get("https://phptravels.net/");
        dr.manage().window().maximize();
        dr.findElement(By.xpath("//input[@id='checkin']")).click();
        Thread.sleep(3000);




    }
}
