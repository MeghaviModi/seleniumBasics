package com.envision.openbrowsers.PracticPrograms;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import java.util.Set;

public class E_commerceApplication {
    @Test
    public static void E_commerceApplicationTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://demo.guru99.com/payment-gateway/index.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
        WebElement cardNumber=driver.findElement(By.xpath("//nav/a[text()='Generate Card Number'] "));
        cardNumber.click();

        Set<String > s=driver.getWindowHandles();
        for(String i : s){
            String t=driver.switchTo().window(i).getTitle();
            System.out.println(t);
        }


//cardNumber
        String  getNumber=driver.findElement(By.xpath("//div[@class='inner']//h4[1]")).getText();
        String CardNum=getNumber.replaceAll("[^0-9]","");
        System.out.println("CardNumber:  "+ CardNum);
//cvvnum
        String  Cvvnum=driver.findElement(By.xpath("//div[@class='inner']/h4[2]")).getText();
        //String CVVdetails=Cvvnum.getText().split(":- ",2)[1];
        String CVVdetails=Cvvnum.replaceAll("[^0-9]","");
        System.out.println("CVV Number: "+CVVdetails);
//Credit limit
        WebElement CreditLimit=driver.findElement(By.xpath("//div[@class='inner']/h4[4]/span"));
        String CreditLimitAmount=CreditLimit.getText();
        System.out.println(CreditLimitAmount);
//ExpDate
       WebElement ExpDate=driver.findElement(By.xpath("//div[@class='inner']/h4[3]"));
        String ExpDate1=ExpDate.getText().split(":- ",2)[1];
        String Month=ExpDate1.split("/",2)[0];
        String year=ExpDate1.split("/",2)[1];
        System.out.println(Month);
        System.out.println(year);

        WebElement CartButton=driver.findElement(By.xpath("//nav[@id='nav']/a[1]"));
        CartButton.click();
        Thread.sleep(3000);
        WebElement Quantity=driver.findElement(By.name("quantity"));
        Select Value= new Select(Quantity);
        Value.selectByIndex(3);

        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);
        //WebElement amount=driver.findElement(By.xpath("//div[@class='row']/div/font[2]"));
        //String TotalAmount=amount.getText().split(" $",2)[1];


        WebElement cardNumTextBox=driver.findElement(By.id("card_nmuber"));
        cardNumTextBox.sendKeys(CardNum);
        Thread.sleep(2000);
        WebElement CvvTextBox=driver.findElement(By.id("cvv_code"));
        CvvTextBox.sendKeys(CVVdetails);
        WebElement MonthSelect=driver.findElement(By.id("month"));
        Select month= new Select(MonthSelect);
        month.selectByVisibleText(Month);
        WebElement Year=driver.findElement(By.id("year"));
        Select ExpYear= new Select(Year);
        ExpYear.selectByVisibleText(year);
        Thread.sleep(3000);
        WebElement totalPrice =driver.findElement(By.xpath("//input[@name='submit']"));
        System.out.println("Actual Price is : "+totalPrice.getAttribute("value"));
        Assert.assertEquals("Pay $80.00",totalPrice.getAttribute("value"));

        WebElement submitButton=driver.findElement(By.name("submit"));
        submitButton.click();
        WebElement paymentConfirmation =driver.findElement(By.xpath("//div[@class='table-wrapper']//h2"));
        System.out.println("Payment Confirmation :" +paymentConfirmation.getText());
        Assert.assertEquals("Payment successfull!",paymentConfirmation.getText());



        WebElement sucessfull=driver.findElement(By.xpath("//tr/td[1]/h3/strong[1]"));
        Assert.assertTrue(sucessfull.isDisplayed());

        driver.quit();

    }
}
