package com.envision.openbrowsers.PracticPrograms;

import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicTable {
    @Test
    public void dynamicTableTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/index.php?route=common/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        Thread.sleep(3000);
        WebElement userName=driver.findElement(By.id("input-username"));
        userName.clear();
        userName.sendKeys("demo");
        WebElement password=driver.findElement(By.id("input-password"));
        password.clear();
        password.sendKeys("demo");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//div[@class='modal-header']/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
        driver.findElement(By.xpath(" //a[normalize-space()='Orders']")).click();

        // find to total Number Of Page
        String Value=driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
        System.out.println(Value);
        int total_page=Integer.valueOf(Value.substring(Value.indexOf("(")+1 , Value.indexOf("Pages")-1));
        System.out.println(total_page);
        //loop statement for all pages
        for(int p=2; p<=5;p++)
        {
            WebElement active_page=driver.findElement(By.xpath("//ul[@class='pagination']//li['"+p+"']"));
            System.out.println("Active Page: "+ active_page.getText());
            active_page.click();
            int row=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr")).size();
            System.out.println("Total NUmber OF: "+row);

            // read data form rows


            String pageNo=Integer.toString(p+1);
            driver.findElement(By.xpath("//ul[@class='pagination']//li/a[text()='"+ pageNo +"']")).click();
        }

        Thread.sleep(3000);
        driver.quit();





    }

}
