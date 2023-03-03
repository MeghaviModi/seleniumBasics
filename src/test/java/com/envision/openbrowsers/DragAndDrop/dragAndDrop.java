package com.envision.openbrowsers.DragAndDrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class dragAndDrop {
    @Test
    public static void dragAndDropTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/meghavimodi/myCode/seleniumBasics/browser_exefilles/chromedriver");
        WebDriver cd = new ChromeDriver();
        cd.manage().window().maximize();
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        cd.get("https://demoqa.com/droppable");
        WebElement drag=cd.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop=cd.findElement(By.xpath("//div[@id='draggable']/following::div[@id='droppable'][1]/p[text()='Drop here']"));

        Thread.sleep(3000);
        Actions allMouseKeyBoardActions=new Actions(cd);
        allMouseKeyBoardActions.dragAndDrop(drag,drop).perform();







    }
}
