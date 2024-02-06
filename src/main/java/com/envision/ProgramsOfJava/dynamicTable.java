package com.envision.ProgramsOfJava;

import io.cucumber.java.ja.但し;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class dynamicTable {
    @Test
   public void TestDyanamictable(){
        //WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.w3schools.com/html/html_tables.asp");
        

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        int rowsize=driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
        int colsize=driver.findElements(By.xpath("//table[@id='customers']//td")).size();
        System.out.println(rowsize+" : "+colsize);

        for (int i=1;i<rowsize;i++){
            for (int j=1;j<=colsize;j++){
                String alldata=driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+(i+1)+"]/td["+j+"]")).getText();
                if (alldata.equalsIgnoreCase("Roland Mendel")){
                    System.out.println(i+"  "+j);
                    break;

                }
            }
        }
       driver.quit();
   }
}
