package com.envision.ProgramsOfJava;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.PseudoColumnUsage;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class OrangeHRMProgram {
    @Test
    public void TestHRM() throws InterruptedException {

        String Username="Admin";
        String Password="admin123";
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.name("username")).sendKeys(Username);
        driver.findElement(By.name("password")).sendKeys(Password);
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        String title=driver.findElement(By.xpath("//*[@class='oxd-userdropdown-name']")).getText();

        Assert.assertEquals(title,"Paul Collings");
        ////*[@class='oxd-main-menu']/li/a/span
        Thread.sleep(2000);
        List<WebElement>  allelement=driver.findElements(By.xpath("//*[@class='oxd-main-menu']/li/a/span"));
        Iterator<WebElement> ele=allelement.iterator();
        while (ele.hasNext()){
            String  value= (ele.next().getText());
            System.out.println(value);
        }
        /*for (WebElement e:allelement){
            System.out.println(e.getText());
        }*/

        driver.findElement(By.xpath("//*[@class='oxd-main-menu']/li[6]/a")).click();
        Thread.sleep(2000);
        String myinfo=driver.findElement(By.xpath("//*[@class='orangehrm-edit-employee-name']/h6")).getText();
        System.out.println(myinfo);
        Assert.assertEquals(myinfo,"Paul Collings");


        Thread.sleep(3000);
        driver.quit();

    }
}
