package com.envision.openbrowsers.PracticPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.BrowserFactory;
import utility.Property_File_Reader;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Ex1 {
    WebDriver driver = null;

    @BeforeMethod

    public void Bm() throws FileNotFoundException {
        String Req1 = Property_File_Reader.getPropertyValue("config", "browsername");
        driver = BrowserFactory.getBrowser(Req1);
    }


    @Test
    public void ExTest() throws InterruptedException {
        driver.get("https://www.snapdeal.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
       //Wait wait=new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

        Thread.sleep(300);
        WebElement com_Gam = driver.findElement(By.xpath("//div[@class='leftNavigationLeftContainer expandDiv']/ul/li[11]"));
        com_Gam.click();
        WebElement storage = driver.findElement(By.xpath("//div[@id='category10Data']/div/div[1]/div[1]/p[2]/a/span[@class='headingText']"));
        storage.click();

        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Locating element by text and store in variable "Element"
        //WebElement Element = driver.findElement(By.xpath("//div[@id='csf-Left-Wrapper']/div[2]/div[4]/div[3]/button"));

        // Scrolling down the page till the element is found
        js.executeScript("window.scrollBy(0,4000)");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,5000)");
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,-1300)");

        // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement Element = driver.findElement(By.xpath("//div[@class='filter-content ']/button[@data-filtername='Capacity_s']"));

        Element.click();
        Thread.sleep(3000);



        List<WebElement> CheckBoxes = driver.findElements(By.xpath("//div[@data-name='Capacity_s']/div/input[@type='checkbox']"));
        System.out.println(CheckBoxes.size());
        int Check_box_count=CheckBoxes.size();


        WebElement temWebElementCheck;
        String svalue="";
        int j=0;
        List<String> tagname=new ArrayList<>();
        Thread.sleep(3000);

        for(int i=1; i<Check_box_count; i++){
            WebElement element_CheckBox =driver.findElement(By.xpath("//div[@data-name='Capacity_s']/div["+i+"]/input[@type='checkbox']"));

            if(element_CheckBox.getAttribute("value").equalsIgnoreCase("16GB") || element_CheckBox.getAttribute("value").equalsIgnoreCase("1.5 TB") || element_CheckBox.getAttribute("value").equalsIgnoreCase("1 TB")){
                svalue=element_CheckBox.getAttribute("value");
                tagname.add(svalue);
                ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element_CheckBox);
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
                j=j+1;

                temWebElementCheck =driver.findElement(By.xpath("//div[@class='filters-top-selected']/div[@class='filters']//div[@class='navFiltersPill' and contains(text(),'Capacity:')]/a["+j+"]"));
                Assert.assertTrue(temWebElementCheck.getText().equalsIgnoreCase(svalue));
                System.out.println("Matched");
            }
        }


        Thread.sleep(3000);
        System.out.println("===========================");
       List<WebElement> delete=driver.findElements(By.xpath("//div[@class='filters-top-selected']/div[@class='filters']//div[@class='navFiltersPill' and contains(text(),'Capacity:')]/a")) ;
        int deleteclick=delete.size();
        System.out.println(deleteclick);
        Thread.sleep(5000);
        String dvalue="";
        int p=0;
        List<String> tagNameDelete=new ArrayList<>();

        for(int i=1; i<deleteclick; i++) {
            WebElement element_CheckBox1 = driver.findElement(By.xpath("//div[@class='filters-top-selected']/div[@class='filters']//div[@class='navFiltersPill' and contains(text(),'Capacity:')]/a[" + i + "]"));

            if (element_CheckBox1.getAttribute("data-value").equalsIgnoreCase("16%20GB") || element_CheckBox1.getAttribute("data-value").equalsIgnoreCase("1.5%20TB") || element_CheckBox1.getAttribute("data-value").equalsIgnoreCase("1%20TB")) {
                dvalue = element_CheckBox1.getAttribute("data-value");
                tagNameDelete.add(dvalue);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element_CheckBox1);
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
                p= p+1;
            }
        }



//div[@class='filters-top-selected']/div[@class='filters']//div[@class='navFiltersPill' and contains(text(),'Capacity:')]/a

    }


    @AfterMethod
    public void Am() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
