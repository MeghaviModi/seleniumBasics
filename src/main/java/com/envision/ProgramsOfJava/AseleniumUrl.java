package com.envision.ProgramsOfJava;

import com.sun.rowset.JdbcRowSetResourceBundle;
import io.cucumber.java.en_scouse.An;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DurationUtils;
import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class AseleniumUrl {
    @Test
    public void myUrl() throws InterruptedException, IOException {
        //WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       // WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
       // WebElement el=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));
        /*Wait wait=new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofSeconds(30))
                                .ignoring(NoSuchElementException.class);*/

       /* driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
        WebElement element=driver.findElement(By.xpath("//div[@class='card mb-3']/div[2]/p/select[@id='first']"));
        System.out.println(element.getText());
        Select select=new Select(element);
        select.selectByVisibleText("Bing");
        Thread.sleep(3000);
        select.selectByVisibleText("Yahoo");*/

        driver.get("https://www.w3schools.com/");
       WebElement search= driver.findElement(By.id("search2"));
        search.click();
        search.sendKeys("Sql");
        List<WebElement> table=driver.findElements(By.xpath("//*[@id='listofsearchresults']/a"));
        System.out.println(table.size());

        for(WebElement i: table){
            String j=(i.getText());
            System.out.println(j);
           if (j.equalsIgnoreCase("SQL Reference")) {
               i.click();
               break;
           }
        }

        Thread.sleep(3000);
        System.out.println(driver.getTitle());

         List<WebElement> link=driver.findElements(By.tagName("a"));
          for (WebElement allLink: link){
              String title= allLink.getText();
           System.out.println(title);
             // System.out.println(allLink.getSize());
            //System.out.println(allLink.getAttribute("href"));
       }
          List<WebElement> Table=driver.findElements(By.xpath("//*[@class='ws-table-all notranslate']/tbody/tr/td/a"));
        System.out.println(Table.size());
        for (WebElement tableText: Table){
            System.out.println(tableText.getText());
            if (tableText.equals("RIGHT JOIN")){
                tableText.click();
                Assert.assertEquals(tableText.getText(),"RIGHT JOIN");
                System.out.println(driver.getTitle());
            }

        }
        

        Thread.sleep(2000);
        driver.quit();


    }
}
