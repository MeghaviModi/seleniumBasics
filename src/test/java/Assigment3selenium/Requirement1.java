package Assigment3selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.BrowserFactory;
import utility.Property_File_Reader;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;


public class Requirement1 {

    @Test
    public static void getRequirement1Test() throws FileNotFoundException, InterruptedException {
        String Req1 = Property_File_Reader.getPropertyValue("config", "browsername");
        WebDriver driver1 = BrowserFactory.getBrowser(Req1);
        String purl = Property_File_Reader.getPropertyValue("config", "URL");
        driver1.get(purl);
        driver1.manage().window().maximize();
        driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement Search = driver1.findElement(By.xpath("//input[@id='search2']"));
        Search.click();
        Search.sendKeys("table");
        WebElement SearchButton = driver1.findElement(By.xpath("//i[@id='learntocode_searchicon']"));
        SearchButton.click();
        WebElement TableLink = driver1.findElement(By.xpath("//div[@class='gs-title']/a[@href='https://www.w3schools.com/html/html_tables.asp']"));
        TableLink.click();
        WebElement TryButton = driver1.findElement(By.xpath("//a[@class='w3-btn w3-margin-top w3-margin-bottom'] "));
        TryButton.click();
        Thread.sleep(3000);

        List<WebElement> companyName = driver1.findElements(By.xpath("//table//tr"));
        System.out.println("size of table:" + companyName.size());
        boolean companyMatch=false;

        for (int i = 1; i < companyName.size(); i++) {
            String actvalue = driver1.findElement(By.xpath("//table//tr[" + (i + 1) + "]/td[1]")).getText();
            if (actvalue.equalsIgnoreCase("Island Trading") ) {
                System.out.println(actvalue );
                companyMatch=true;

            }

            if (actvalue.equalsIgnoreCase("Magazzini Alimentari Riuniti")) {
                System.out.println(actvalue);
                companyMatch=true;
                break;
            }
        }
        Assert.assertTrue(companyMatch,"company is not match");

        System.out.println("===============================");

        List<WebElement> countryName = driver1.findElements(By.xpath("//table//td"));
        System.out.println("size of table:" + countryName.size());
        boolean length=countryName.size()<6;
        for (int i = 1; i < countryName.size(); i++) {
            String actvalue = driver1.findElement(By.xpath("//table//tr[" + (i + 1) + "]/td[3]")).getText();

            if (actvalue.equalsIgnoreCase("uk")) {
                System.out.println(actvalue + "  "+ " size of County: "+actvalue.length());
                length=true;
            }
            if (actvalue.equalsIgnoreCase("Italy")) {
                System.out.println(actvalue + "  "+"  size of county: "+ actvalue.length());
                length=true;
                break;
            }
        }
        Assert.assertTrue(length,"more then 6 character");

        driver1.quit();


    }


}
