package AssigmentSelenium;

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

public class Class_loginPass_Fail_Runner {
    WebDriver driver=null;
    @BeforeMethod
    public void preRequisite() throws FileNotFoundException {
        String brn= Property_File_Reader.getPropertyValue("config","browsername");
        driver = BrowserFactory.getBrowser(brn);
        String purl = Property_File_Reader.getPropertyValue("config","negative_url");
        driver.get(purl);

    }

    @Test
    public void positiveLoginTest() throws FileNotFoundException, InterruptedException {

        WebElement uname=driver.findElement(By.name("username"));
        uname.clear();
        uname.click();
        uname.sendKeys(Property_File_Reader.getPropertyValue("config","positive_username"));

        WebElement pwd=driver.findElement(By.name("password"));
        pwd.clear();
        pwd.click();
        pwd.sendKeys(Property_File_Reader.getPropertyValue("config","positive_password"));

        WebElement loginButton= driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();
        Thread.sleep(5000);

        WebElement welcomeText=driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']/p"));
        Assert.assertTrue(welcomeText.isDisplayed());



    }
    @Test
    public void negativeLoginTest() throws FileNotFoundException, InterruptedException {


        WebElement uname=driver.findElement(By.name("username"));
        uname.clear();
        uname.click();
        uname.sendKeys(Property_File_Reader.getPropertyValue("config","negative_username"));

        WebElement pwd=driver.findElement(By.name("password"));
        pwd.clear();
        pwd.click();
        pwd.sendKeys(Property_File_Reader.getPropertyValue("config","negative_password"));

        WebElement loginButton= driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();
        Thread.sleep(5000);

        WebElement invalidText=driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
        Assert.assertTrue(invalidText.isDisplayed());
        Thread.sleep(5000);


    }
    @AfterMethod
    public void closure(){
        driver.quit();
    }

}
