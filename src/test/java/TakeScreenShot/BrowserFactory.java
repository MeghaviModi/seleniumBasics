package TakeScreenShot;

import jdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserFactory {
    public static WebDriver driver = null;

    private static void ChromeOpenBrowser() {
            System.setProperty("webdriver.chrome.driver", "browser_exefilles/chromedriver");
            driver = new ChromeDriver();
    }
    private static void firefoxOpenBrowser() {
            System.setProperty("webdriver.gecko.driver", "browser_exefilles/geckodriver");
            driver = new FirefoxDriver();
    }
public static WebDriver OpneBrowser(String BrowserType){
        if(BrowserType.equalsIgnoreCase("chrome")){
            ChromeOpenBrowser();
        }else  if(BrowserType.equalsIgnoreCase("firefox")){
            firefoxOpenBrowser();
        }else {
            System.out.println("different BrowserType");
        }
        return driver;

}
public static void OpenBroserApplication (){
    String Url="https://www.browserstack.com/guide/selenium-scroll-tutorial";
        driver.get(Url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
}
public static void closeBrowser(){
        driver.close();
}
public static void quitBrowser(){
        driver.quit();
}

}
