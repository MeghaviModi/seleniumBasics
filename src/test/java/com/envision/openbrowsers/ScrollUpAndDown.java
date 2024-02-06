package com.envision.openbrowsers;

import com.google.gson.JsonObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollUpAndDown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.ca/");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        Thread.sleep(2000);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
        WebElement bestseller=driver.findElement(By.xpath("//div[@id=\"nav-xshop\"]/a[1]"));
        bestseller.click();

        Thread.sleep(3000);
        driver.quit();




    }
}
