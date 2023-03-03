package com.envision.openbrowsers.readyDataFromProperties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class readyDataFromProperty {
    public static void main(String[] args) throws InterruptedException {
        abc();
    }

    public static void abc() throws InterruptedException {
        String BrowserName = readyDataFromProperty.getconfigdata("config", "browsername");
        String Url_From_file = readyDataFromProperty.getconfigdata("config", "url");
        WebDriver driver = null;
        if (BrowserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/meghavimodi/myCode/Downloads/geckodriver");
            driver = new FirefoxDriver();
        } else if (BrowserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
            driver = new ChromeDriver();
        }
            driver.get(Url_From_file);
            Thread.sleep(5000);
            driver.quit();

    }


        public static String getconfigdata (String filename, String keyName){
            try (FileInputStream fis = new FileInputStream("data/" + filename + ".properties")) {
                Properties p = new Properties();
                p.load(fis);
                return p.getProperty(keyName);
            } catch (Exception e) {


            }return null;
        }


    }

