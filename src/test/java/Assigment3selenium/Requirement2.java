package Assigment3selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utility.BrowserFactory;
import utility.Property_File_Reader;
import java.awt.*;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;



public class Requirement2 {
    @Test
    public static void getRequirement2Test() throws FileNotFoundException, InterruptedException, AWTException {
        String Req1 = Property_File_Reader.getPropertyValue("config", "browsername");
        WebDriver driver1 = BrowserFactory.getBrowser(Req1);
        String purl = Property_File_Reader.getPropertyValue("config", "URL");
        driver1.get(purl);
        driver1.manage().window().maximize();
        driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        WebElement Search = new WebDriverWait(driver1,Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1))
                        .until(dr -> dr.findElement(By.xpath("//input[@type='text' and contains(@placeholder,'Search')]")));
        Search.clear();
        Search.sendKeys("SQL");
        driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement SqlReference = new WebDriverWait(driver1,Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2))
                        .until(driver -> driver1.findElement(By.xpath("//a[@class='search_item' and contains(@href,'ref_keywords')]")));
        SqlReference.click();

        Thread.sleep(3000);
        int AllLinkCounts = driver1.findElements(By.xpath("//table[@class='ws-table-all notranslate']/tbody/tr/td/a")).size();


        List<WebElement> linkList = driver1.findElements(By.xpath("//table[@class='ws-table-all notranslate']/tbody/tr/td/a"));
        String[] links = new String[AllLinkCounts];


        for (int i=0;i<AllLinkCounts;i++) {
            links[i] = linkList.get(i).getAttribute("href");
            System.out.println(links[i]);
        }
        System.out.println(AllLinkCounts+"End Of LINKS");
        System.out.println("===================================");

        for (int lcount=AllLinkCounts-1; lcount>=0;lcount--)
        {
            driver1.navigate().to(links[lcount]);
            Thread.sleep(2000);
            System.out.println(driver1.getTitle());
        }
        driver1.quit();
    }

}






