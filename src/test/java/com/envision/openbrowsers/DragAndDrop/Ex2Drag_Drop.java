package com.envision.openbrowsers.DragAndDrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex2Drag_Drop {
    @Test
    public static void DropAndDragTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        WebDriver cd = new ChromeDriver();
        cd.manage().window().maximize();
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        cd.get("https://www.globalsqa.com/demo-site/draganddrop/#Accepted%20Elements");
        Thread.sleep(3000);
        cd.switchTo().frame(cd.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));

        Thread.sleep(3000);
        WebElement drag1=cd.findElement(By.xpath("//h5[normalize-space()='High Tatras']"));
        WebElement drop1=cd.findElement(By.id("trash"));

        Actions MouseAction=new Actions(cd);
        MouseAction.dragAndDrop(drag1,drop1).perform();

        Thread.sleep(3000);
        cd.quit();

    }
}
