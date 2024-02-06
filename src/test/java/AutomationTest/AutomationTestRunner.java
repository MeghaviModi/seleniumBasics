package AutomationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationTestRunner {
    @Test
    public static void TestApplication() throws InterruptedException {
        // Initialize WebDriver
        WebDriver driver=new ChromeDriver();
        driver.get("http://localhost:8080/");

        //Homepage Title
        String HomePage=driver.getTitle();
        System.out.println(HomePage);
       // click on multiplication
        //another xpath= //*[@class='nav__link' and contains(text(),'Multiplications')]
        driver.findElement(By.xpath("//*[contains(@class, 'nav')]//*[text() = 'Multiplications']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("value1")).sendKeys("4");
        Thread.sleep(1000);
        driver.findElement(By.id("value2")).sendKeys("5");
        Thread.sleep(2000);
        driver.findElement(By.id("go")).click();
        //Get Multiplication Result
        String Result=driver.findElement(By.id("result")).getText();
        System.out.println(Result);
        Assert.assertEquals(Result,"20");

        //Click on Division
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='nav__link' and contains(text(),'Divisions')]")).click();
        driver.findElement(By.id("value1")).sendKeys("10");
        driver.findElement(By.id("value2")).sendKeys("0");
        Thread.sleep(2000);
        driver.findElement(By.id("go")).click();
        Thread.sleep(1000);
        //Result of division
        String ResultDivision=driver.findElement(By.id("result")).getText();
        System.out.println(ResultDivision);
        //Assert.assertEquals(ResultDivision,"");

        //Click on Random
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@class='nav__link' and contains(text(),'Random')]")).click();
        driver.findElement(By.id("value1")).sendKeys("20");
        driver.findElement(By.id("value2")).sendKeys("40");
        Thread.sleep(2000);
        driver.findElement(By.id("go")).click();

        //Result of division
        String ResultRandom=driver.findElement(By.id("result")).getText();
        System.out.println(ResultRandom);
        Thread.sleep(2000);
        driver.quit();
    }
}
