package com.envision.openbrowsers.SwitchBetween_Multiple_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class UsingWindowHandle {
    @Test
    public static void switchBetweenMultipleWindowTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        WebDriver dr=new ChromeDriver();
        dr.manage().window().maximize();
        dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        dr.get("https://chromedriver.chromium.org/");
        Set<String> allWindows = Collections.singleton(dr.getWindowHandle());
        System.out.println(allWindows.size());
        String pageTitle=dr.getTitle();
        System.out.println(pageTitle);
        String lastXpath="//li[2]/p[text()='Latest']//a[contains(text(),'105')]";
        WebElement latestStableLink=new WebDriverWait(dr,Duration.ofSeconds(2)).until(d ->d.findElement(By.xpath(lastXpath)));
        latestStableLink.click();
       // new WebDriverWait(dr,Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).until(ExpectedConditions.numberOfWindowsToBe(2));
        allWindows=dr.getWindowHandles();
        System.out.println(allWindows.size());
        System.out.println(dr.getTitle());
        ArrayList<String> allWindowsByIndex=new ArrayList<>(allWindows);
        dr.switchTo().window(allWindowsByIndex.get(1));

        System.out.println(dr.getTitle());

        List<WebElement> allLink=dr.findElements(By.xpath("//table//tr"));
        boolean linkMatch=false;
        for(int index=4; index < allLink.size() -1; index++){
            String dynamicXpath="//table//tr[" + index + "]/td[2]/a";
            WebElement eachLink= dr.findElement(By.xpath(dynamicXpath));
            System.out.println(eachLink.getText());
            if(eachLink.getText().equalsIgnoreCase("chromedriver_linux64.zip")){
                linkMatch=true;
            }
            System.out.println(eachLink);
            Assert.assertTrue(linkMatch,"link is not match");
        }
        Thread.sleep(3000);
        dr.quit();



    }
}
