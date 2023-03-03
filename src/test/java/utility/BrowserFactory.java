package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserFactory {
    public static WebDriver driver;
    public static WebDriver getBrowser(String browsername){
        if(browsername.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","browser_exefilles/geckodriver");
            driver = new FirefoxDriver();
        }else if (browsername.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","browser_exefilles/chromedriver");
            driver =new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        return driver;
    }


}
