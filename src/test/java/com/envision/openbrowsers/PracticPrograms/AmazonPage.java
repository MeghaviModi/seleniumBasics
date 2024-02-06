package com.envision.openbrowsers.PracticPrograms;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AmazonPage {
    @Test
    public static void AmazonPageTest() throws InterruptedException {
        /*WebDriverManager.chromedriver().setup();
        WebDriver Driver=new ChromeDriver();*/
        System.setProperty("webdriver.gecko.driver", "/Users/meghavimodi/myCode/Downloads/geckodriver");
        WebDriver Driver = new FirefoxDriver();

        Driver.get("https://www.amazon.ca/");
       // Driver.manage().window().maximize();
        Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        Thread.sleep(3000);
        Driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Book");
        Thread.sleep(3000);
        List<WebElement> TotalList=Driver.findElements(By.xpath("//div[@class='autocomplete-results-container']/div"));
        System.out.println(TotalList.size());                          //div[@class='autocomplete-results-container']
        //ArrayList<String> iList= new ArrayList<>();

        //Assert.assertEquals(TotalList.size(),10);

        for(int i=0; i<TotalList.size(); i++){
            String listItem=TotalList.get(i).getText();
            System.out.println(listItem);
            if(listItem.contains("bookcase"))
            {
                TotalList.get(i).click();
                break;
            }
        }
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) Driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        //Driver.findElement(By.id("brandsRefinements"));
       // Driver.findElement(By.xpath("//li[@aria-label='Rolanstar']")).click();
        System.out.println(Driver.getTitle());







        Thread.sleep(3000);

        Driver.quit();

    }

}
