package Assigment3selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.BrowserFactory;
import utility.Property_File_Reader;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebPageTest {
    public static WebDriver dr;
    public static Actions webElement1;

    public static void getBrowser() throws IOException {

        try (FileInputStream fs = new FileInputStream("config_file_location\\browsername.properties")) {
            Properties p = new Properties();
            p.load(fs);
            Thread.sleep(1000);
            if (p.getProperty("browser").equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "browser_exefiles/geckodriver.exe");
                dr = new FirefoxDriver();
            } else if (p.getProperty("browser").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "browser_exefiles/chromedriver.exe");
                dr = new ChromeDriver();
            } else if (p.getProperty("browser").equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", "browser_exefiles/msedgedriver.exe");
                dr = new EdgeDriver();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();

        }

    }
    @BeforeMethod

    public static void openBrowser() throws IOException {

        getBrowser();
        webElement1= new Actions(dr);
        dr.get("http://demo.guru99.com/payment-gateway/index.php");
        dr.manage().window().maximize();
    }

    @Test
    public static void testRun() throws InterruptedException, AWTException {



        String currentHandle = dr.getWindowHandle();
        WebElement webElement = dr.findElement(By.xpath("//a[@href='cardnumber.php' and contains(text(),'Generate Card Number')]"));
        Thread.sleep(1000);
        //webElement.click();
        String urlTo = dr.findElement(By.xpath("//nav[@id='nav']/a[@href='cardnumber.php' and contains(text(),'Generate Card Number')]")).getAttribute("href");
        webElement.click();

        Set<String> handles = dr.getWindowHandles();

        for (String actual : handles) {
            if (!actual.equalsIgnoreCase(currentHandle)) {
                dr.switchTo().window(actual);
                dr.get(urlTo);
            }
        }
        String cardNumber = null;
        String cardCVV= null;
        String cardExYear= null;
        String cardExMonth= null;
        String cardLimit =null;
        String priceValue=null;
        String qtySelected = null;
        webElement = dr.findElement(By.xpath("//div[@class='inner']//h4[1]"));
        cardNumber=webElement.getText();
        webElement = dr.findElement(By.xpath("//div[@class='inner']//h4[2]"));
        cardCVV=webElement.getText();
        webElement = dr.findElement(By.xpath("//div[@class='inner']//h4[3]"));
        cardExYear=webElement.getText().split("/",2)[1];
        webElement = dr.findElement(By.xpath("   //div[@class='inner']//h4[3]"));
        cardExMonth=webElement.getText().split("/",2)[0];
        webElement = dr.findElement(By.xpath("   //div[@class='inner']//h4[4]"));
        cardLimit=webElement.getText();


        webElement = dr.findElement(By.xpath("//nav[@id='nav']/a[@href='purchasetoy.php']"));
        webElement.click();

        webElement= dr.findElement(By.xpath("//h3[contains(text(),'Price')]"));
        priceValue=webElement.getText();

        webElement = dr.findElement(By.xpath("//select[@name='quantity']"));
        Select s = new Select(webElement);
        s.selectByIndex(3);

        qtySelected=s.getFirstSelectedOption().getText();

        System.out.println(priceValue+" "+qtySelected+" ");
        System.out.println(Integer.parseInt(priceValue) * Integer.parseInt(qtySelected));

        webElement = dr.findElement(By.xpath("//input[@type='submit']"));
        webElement.click();
        Thread.sleep (1000);

        System.out.println(dr.getCurrentUrl());
        Thread.sleep(1000);
        webElement = dr.findElement(By.xpath("//input[@name='card_nmuber']"));
        webElement.sendKeys(cardNumber);

        webElement = dr.findElement(By.xpath("//select[@name='month']"));
        s = new Select(webElement);
        s.selectByVisibleText(cardExMonth);

        webElement = dr.findElement(By.xpath("//select[@name='year']"));
        s = new Select(webElement);
        s.selectByValue(cardExYear);

        webElement = dr.findElement(By.xpath("//input[@name='cvv_code']"));
        webElement.sendKeys(cardCVV);
        Thread.sleep (5000);
        webElement = dr.findElement(By.xpath("//input[@name='submit']"));
        webElement.click();

        webElement = dr.findElement(By.xpath("//div[@class='table-wrapper']/h2"));
        Assert.assertTrue(webElement.getText().contains("Payment successfull!"), "PURCHASE FAILED!!!");

        webElement=dr.findElement(By.xpath("//table[@class='alt access']/tbody/tr/td[2]/h3/strong"));
        String orderID = webElement.getText();
        System.out.println(orderID);

        webElement=dr.findElement(By.xpath("//nav[@id='nav']/a[contains(text(),'Check Credit Card Limit')]"));
        webElement.click();
        dr.get(webElement.getAttribute("href"));

        webElement = dr.findElement(By.xpath("//input[@type='text']"));
        webElement.sendKeys(cardNumber);
        Thread.sleep(1000);
        webElement = dr.findElement(By.xpath("//input[@type='submit']"));
        webElement.click();


        String amountBalance = String.valueOf(100 -Integer.parseInt(priceValue)*Integer.parseInt(qtySelected));
        webElement = dr.findElement(By.xpath("//div[@class='table-wrapper']/h4/span"));
        Assert.assertEquals(webElement.getText(),amountBalance,"NOT BALANCED");
        System.out.println(webElement.getText() +" : " + amountBalance);


        webElement = dr.findElement(By.xpath("//div[@class='table-wrapper']/table[@class='alt']/tbody/tr/td[6]"));
        System.out.println("ORDER ID:"+webElement.getText());
        Assert.assertEquals(webElement.getText(),orderID,"ORDER ID DOES NOT MATCH!!!");



        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


}


