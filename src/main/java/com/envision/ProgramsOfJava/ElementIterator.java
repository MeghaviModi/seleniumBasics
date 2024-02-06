package com.envision.ProgramsOfJava;

import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ElementIterator {
    @Test
    public void TestElement(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/sql/sql_select.asp");
        JavascriptExecutor js= ( JavascriptExecutor)driver ;
        js.executeScript("window.scrollBy(0,100)","");
        List<WebElement> table=driver.findElements(By.xpath("//*[@class='ws-table-all notranslate']/tbody/tr/td"));
        Iterator<WebElement> element= table.iterator();
        while(element.hasNext()){
            WebElement allelement= element.next();
            System.out.println(allelement.getText());
        }
        driver.quit();

    }
}
