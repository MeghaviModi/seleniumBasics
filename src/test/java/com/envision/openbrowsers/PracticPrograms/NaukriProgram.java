package com.envision.openbrowsers.PracticPrograms;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class NaukriProgram {
    @Test
    public static void NuakriProgramTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver cd=new ChromeDriver();
        cd.get("https://www.naukri.com/");
        cd.manage().window().maximize();
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        cd.findElement(By.id("register_Layer")).click();
        Thread.sleep(3000);
        cd.quit();

    }
}
