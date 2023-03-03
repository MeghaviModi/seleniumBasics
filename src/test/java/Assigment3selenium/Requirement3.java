package Assigment3selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BrowserFactory;
import utility.Property_File_Reader;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Requirement3 {
    @Test
    public static void getRequirement3Test() throws FileNotFoundException, InterruptedException {
        String Req1 = Property_File_Reader.getPropertyValue("config", "browsername");
        WebDriver driver1 = BrowserFactory.getBrowser(Req1);
        driver1.get("https://www.yahoo.com/");
        driver1.manage().window().maximize();
        driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver1.findElement(By.xpath("//input[@id='ybar-sbq']")).sendKeys("test ");
        driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        List<WebElement> list = driver1.findElements(By.xpath("//li[@role='option']"));
        System.out.println("total number of suggestions in " + list.size());
        ArrayList<String> iList= new ArrayList<>();

        Assert.assertEquals(list.size(),10);

        for (WebElement w : list) {
            iList.add(w.getAttribute("data"));
        }
        Collections.sort(iList, (a1, a2) -> Integer.compare(a1.length(),a2.length()));
        WebElement finalClick = driver1.findElement(By.xpath("//li[@data='"+iList.get(6)+"']"));
        String listName= finalClick.getAttribute("data");
        finalClick.click();
        Thread.sleep(1000);
        Assert.assertTrue(driver1.getTitle().substring(0,listName.length()).equalsIgnoreCase(listName));
        System.out.println("CONDITION MATCHED");


        driver1.quit();

    }

}

