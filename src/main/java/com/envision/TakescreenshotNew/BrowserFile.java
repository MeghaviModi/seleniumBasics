package com.envision.TakescreenshotNew;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserFile {
    public static WebDriver driver=null;
    public static void getChromeDriver(){
        System.setProperty("webdriver.chorome.driver", "browser_exefilles/chromedriver");
        driver =new ChromeDriver();
    }
    public static void getFirFoxDriver(){
        System.setProperty("wrbdriver.gecko.driver","browser_exefilles/geckodriver");
        driver=new FirefoxDriver();

    }

    public static WebDriver getBrowser(String Browser){
        if (Browser.equalsIgnoreCase("chrome")){
            getChromeDriver();
        }else if (Browser.equalsIgnoreCase("firefox")){
            getFirFoxDriver();
        }else {
            System.out.println(Browser+"  "+"wrong Type Browser");
        }
        return driver;
    }
    public static void getApplication(){
        String url="https://www.w3schools.com/";
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public static void getSearch(String Type){
        WebElement element=driver.findElement(By.id("search2"));
        element.sendKeys(Type);
    }
    public static void ClickButton(){
        WebElement searchButton= driver.findElement(By.id("learntocode_searchicon"));
        searchButton.click();
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Java Tutorial");

    }

    public static void teardownBrowser(){
        driver.quit();
    }
}
