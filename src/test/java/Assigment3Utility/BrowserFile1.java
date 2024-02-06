package Assigment3Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.time.Duration;

public class BrowserFile1 {
    public static WebDriver driver1;
    public static WebDriver getBrowser1(String browsername) {
        if (browsername.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "browser_exefilles/geckodriver");
            driver1 = new FirefoxDriver();
        } else if (browsername.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "browser_exefilles/chromedriver");
            driver1 = new ChromeDriver();
        }
        driver1.manage().window().maximize();
        driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        return driver1;
       
    }
}
