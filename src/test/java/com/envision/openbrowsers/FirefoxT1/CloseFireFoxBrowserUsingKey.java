package com.envision.openbrowsers.FirefoxT1;

import com.sun.glass.events.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;

public class CloseFireFoxBrowserUsingKey {
    public static void getFireFoxBrowserKey() throws InterruptedException, AWTException {
        System.setProperty("webdriver.gecko.driver", "/Users/meghavimodi/myCode/Downloads/geckodriver");
        WebDriver fd = new FirefoxDriver();
        fd.get("https://www.google.com/");
        fd.manage().window().maximize();
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_COMMAND);
        Thread.sleep(500);
        r.keyPress(KeyEvent.VK_W);
        Thread.sleep(500);
        r.keyRelease(KeyEvent.VK_COMMAND);
        r.keyRelease(KeyEvent.VK_W);
        Thread.sleep(5000);
        //cd.close();
        fd.quit();
    }
}
class CloseFireFoxBrowserTest{
    public static void main(String[] args) throws InterruptedException, AWTException {
        CloseFireFoxBrowserUsingKey.getFireFoxBrowserKey();
    }
}
