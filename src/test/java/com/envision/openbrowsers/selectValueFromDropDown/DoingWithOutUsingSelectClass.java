package com.envision.openbrowsers.selectValueFromDropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DoingWithOutUsingSelectClass {
    @Test
    public static void withoutSelect() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        WebDriver cd = new ChromeDriver();
        cd.manage().window().maximize();
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        cd.get("https://www.facebook.com/");
        WebElement createNewAcc=cd.findElement(By.linkText("Create new account"));
        createNewAcc.click();
        Thread.sleep(5000);
        List<WebElement> monthOptionList =cd.findElements(By.xpath("//select[@id='month']/option"));
        System.out.println(monthOptionList.size());
        for(WebElement t: monthOptionList){
            if(t.getText().equalsIgnoreCase("mar")){
                t.click();
                break;
            }
        }
        Thread.sleep(5000);
        List<WebElement> yearOptionList =cd.findElements(By.xpath("//select[@id='year']/option"));
        System.out.println(yearOptionList.size());
        yearOptionList.get(12).click();
        Thread.sleep(5000);

        List<WebElement> dayOptionList =cd.findElements(By.xpath("//select[@id='day']/option"));
        System.out.println(dayOptionList.size());
        for(WebElement t: dayOptionList){
            if(Integer.valueOf(t.getAttribute("value"))==24){
                t.click();break;

            }
        }
        Thread.sleep(3000);
        cd.quit();

    }
}
