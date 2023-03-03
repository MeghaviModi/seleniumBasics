package com.envision.openbrowsers.ChromeBrowserT1;

import com.sun.glass.events.KeyEvent;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.*;
public class CloseChromeBrowser {
    public static void getChromeBrowser() throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        ChromeDriver cd = new ChromeDriver();
        cd.get("https://www.google.com/");
        Thread.sleep(5000);
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Robot r =new Robot();
        r.keyPress(KeyEvent.VK_COMMAND);
        Thread.sleep(500);
        r.keyPress(KeyEvent.VK_W);
        Thread.sleep(500);
        r.keyRelease(KeyEvent.VK_COMMAND);
        r.keyRelease(KeyEvent.VK_W);
    }
}
class CloseChromeBrowserTest{
    public static void main(String[] args) throws InterruptedException, AWTException {
        CloseChromeBrowser.getChromeBrowser();
    }
}
