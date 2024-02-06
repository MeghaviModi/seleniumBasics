package com.envision.ProgramsOfJava;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class windowhandleusingIterator {
    @Test
   public void mytest(){
       //WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver","/Users/meghavimodi/IdeaProjects/seleniumtest/drivers/chromedriver_mac_arm64/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("windowButton")).click();

        Set<String> window=driver.getWindowHandles();
        Iterator<String > iterator=window.iterator();
        while (iterator.hasNext()){
            iterator.next();
          String alltitle=driver.getTitle();
            System.out.println(alltitle);
        }
        driver.quit();
   }


}
