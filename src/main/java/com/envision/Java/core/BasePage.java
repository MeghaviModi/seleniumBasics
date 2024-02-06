package com.envision.Java.core;

import com.envision.Java.utills.ORUtills;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BasePage {

    public static WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver =driver;
    }
    //LunchBrowser Method
        public static WebDriver lunchBrowser(String Browser) {
            if (Browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (Browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();

            } else {
                throw new UnsupportedOperationException("Browser Type [ " + Browser + " ] is not supported");
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
        }

    //LunchURL Methods
    public void urlLunch(String URL) {
        this.driver.get(URL);

    }
    //Create By class and using that we can call locators
    public By getFindBy(String propertyName){
        By by=null;
        String orElementValue= ORUtills.getORPropertyValue(propertyName);
        String byMode=orElementValue.split("#",2)[0];
        String byValue=orElementValue.split("#",2)[1];
        if (byMode.equalsIgnoreCase("id")){
            by=By.id(byValue);
        }else if (byMode.equalsIgnoreCase("name")){
            by=By.name(byValue);
        }else if (byMode.equalsIgnoreCase("tagName")){
            by=By.tagName(byValue);
        }else if (byMode.equalsIgnoreCase("xpath")){
            by=By.xpath(byValue);
        }else {
            throw new UnsupportedOperationException("BYMode value is not found[ "+by+" ]");
        }
        return by;

    }
}
