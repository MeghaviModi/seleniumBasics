package com.envision.openbrowsers.PracticPrograms;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleWebPage {
    @Test
    public static void GoggleWebpageTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver Driver=new ChromeDriver();
        Driver.get("https://www.google.com/");
        Driver.manage().window().maximize();
        Thread.sleep(3000);
        Driver.findElement(By.name("q")).sendKeys("Java");
        Thread.sleep(3000);
        List<WebElement> list=Driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='eIPGRd']"));
        System.out.println(list.size());

                                  //ul[@role='listbox']//li/descendant::div[@class='eIPGRd']
        for(int i=0; i<list.size(); i++){
            String listItem=list.get(i).getText();
            System.out.println(listItem);
            if(listItem.contains("javascript"))
            {
                list.get(i).click();
                break;
            }
        }
    }

}
