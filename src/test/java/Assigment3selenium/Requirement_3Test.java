package Assigment3selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BrowserFactory;
import utility.Property_File_Reader;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Requirement_3Test {
    @Test
    public static void getRequirement3Test() throws FileNotFoundException, InterruptedException {
        String Req1 = Property_File_Reader.getPropertyValue("config", "browsername");
        WebDriver driver1 = BrowserFactory.getBrowser(Req1);
        driver1.get("https://www.yahoo.com/");
        driver1.manage().window().maximize();
        driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        WebElement searchBar = driver1.findElement(By.xpath("//input[@type='text' and @id='ybar-sbq']"));
        searchBar.clear();
        searchBar.sendKeys("test");

        driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));                                                                   // Wait

        List<WebElement> aList = driver1.findElements(By.xpath("//li[@role='option']"));                                                      // Find Total elements in Search list
        ArrayList<String> iList= new ArrayList<>();                                                                                           // Initializing ArrayList to compare length
        Assert.assertEquals(aList.size(),10);                                                                                                 // Validate is items = 10

        for (WebElement w : aList) {                                                                                                          // Saving Data text in ArrayList
            iList.add(w.getAttribute("data"));
        }

        Collections.sort(iList, (a1, a2) -> Integer.compare(a1.length(),a2.length()));                                                        // Sort

        WebElement finalClick = driver1.findElement(By.xpath("//li[@data='"+iList.get(8)+"']"));                                              // Retrieve element to click
        String listName= finalClick.getAttribute("data");                                                                                     // Save data of element to compare with
        finalClick.click();
        Thread.sleep(1000);

        Assert.assertTrue(driver1.getTitle().substring(0,listName.length()).equalsIgnoreCase(listName));
        System.out.println("CONDITION MATCHED");
        driver1.quit();
    }
}
