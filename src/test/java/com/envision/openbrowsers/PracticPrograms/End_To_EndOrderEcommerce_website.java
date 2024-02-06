package com.envision.openbrowsers.PracticPrograms;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class End_To_EndOrderEcommerce_website {
    @Test
    public static void buyOrderFunctionalityTest() throws InterruptedException {
        //WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //step1: OpenUrl
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //step2 : LoginTo Website
        driver.findElement(By.xpath("//a[@class='login']")).click();
        WebElement username=driver.findElement(By.id("email"));
        username.sendKeys("hey@abc.com");
        WebElement password=driver.findElement(By.id("passwd"));
        password.sendKeys("Testing@1234");
        driver.findElement(By.id("SubmitLogin")).click();
        //step3 click On T-shirt  subMenu
        driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[3]")).click();
        //step4: click on T-shirtImage
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='product-image-container']/a")).click();
        //step5: click on add to cart after switch to frame
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//div[@class='box-cart-bottom']/div/p/button[@type='submit']")).click();
        Thread.sleep(2000);
        //Step 6: validate Product Successfully added to cart
        WebElement text=driver.findElement(By.xpath("//div[@class='clearfix']/div[@class='layer_cart_product col-xs-12 col-md-6']/h2"));
        String TextValue=text.getText();
        System.out.println(TextValue);
        Assert.assertEquals("Product successfully added to your shopping cart",TextValue);

        //step7: Click on CheckOut
        driver.findElement(By.xpath("//div[@class='button-container']/a/span[contains(text(),'checkout')]")).click();
        Thread.sleep(3000);
        //Step8: fetch total price
        WebElement total=driver.findElement(By.xpath("//table/tfoot/tr[7]/td[2]/span"));
        //System.out.println(total.getText());
        String TotalPrice="$19.25";
        Assert.assertEquals(total.getText(),TotalPrice);
        System.out.println("Total Price is not More then 20$ "+ total.getText());
        Thread.sleep(2000);
        //step10: ClickOnCheckOut
        driver.findElement(By.xpath("//p/a/span[contains(text(),'checkout')]")).click();
        WebElement CheckOut=driver.findElement(By.xpath("//p/button[@type='submit']/span"));
        CheckOut.click();
        //step11: clickOnCheckBox Text
        WebElement CheckBox=driver.findElement(By.xpath("//p[@class='checkbox']/label"));
        CheckBox.click();
        System.out.println(CheckBox.getText());
        //step12 : fetch delivery fees
        String DeliveryFee=driver.findElement(By.xpath("//td[4]/div")).getText();
        System.out.println("Delivery Fee: "+DeliveryFee);
        Assert.assertEquals(DeliveryFee,"$2.00");

        Thread.sleep(2000);
        //step 13 Processed To chekout
        driver.findElement(By.xpath("//p/button[@type='submit']/span")).click();
        Thread.sleep(200);
        //setp14: clickOn Bankwire
        driver.findElement(By.xpath("//p/a[@class='bankwire']")).click();
        Thread.sleep(2000);
        //step15: conformMyOrder
        driver.findElement(By.xpath("//p/button[@type='submit']/span")).click();

        Thread.sleep(3000);
        //step16:  validate OrderConformation

        WebElement ConformOrder=driver.findElement(By.xpath("//p[@class='cheque-indent']/strong"));
        String conformText=ConformOrder.getText();
        System.out.println(ConformOrder.isDisplayed()+" "+ conformText);

// step17: fetch the wire details TotalAmount, Name, BankName
        String TotalAmount=driver.findElement(By.xpath("//div[@class='box']/span/strong")).getText();

        String Name=driver.findElement(By.xpath("//div[@class='box']/strong[1]")).getText();
        String BankName=driver.findElement(By.xpath("//div[@class='box']/strong[3]")).getText();
        System.out.println("total amount: "+ TotalAmount);
        System.out.println("name of account owner : "+ Name);
        System.out.println("name of bank: "+ BankName);

        Thread.sleep(30000);
        driver.quit();
    }
}
