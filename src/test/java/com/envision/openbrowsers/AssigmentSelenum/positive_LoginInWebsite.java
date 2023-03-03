package com.envision.openbrowsers.AssigmentSelenum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class positive_LoginInWebsite {

    public static void openUrl_positive(String Username,String Password) throws InterruptedException {

        String BrowserName = positive_LoginInWebsite.getconfigdata("config", "browsername");
        String Url_From_file = positive_LoginInWebsite.getconfigdata("config", "positive_url");
        WebDriver driver = null;
        if (BrowserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/meghavimodi/myCode/Downloads/geckodriver");
            driver = new FirefoxDriver();
        } else if (BrowserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.get(Url_From_file);

        WebElement userName=driver.findElement(By.name("username"));
        userName.sendKeys(Username);
        userName.click();

        WebElement passWord=driver.findElement(By.name("password"));
        passWord.sendKeys(Password);
        passWord.click();
        WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        System.out.println("welcome");
        WebElement welcomeText=driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']/p"));
        Assert.assertTrue(welcomeText.isDisplayed());
        Thread.sleep(5000);
        driver.quit();
    }
    public static String getconfigdata (String filename, String keyName){
        try (FileInputStream fis = new FileInputStream("data/" + filename + ".properties")) {
            Properties p = new Properties();
            p.load(fis);
            return p.getProperty(keyName);
        } catch (Exception ignored) {

        }return null;
    }

    public static void main(String[] args) throws InterruptedException {
        openUrl_positive("Admin","admin123");
    }

}
