package AutomationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiplicationsPageTest {
    private WebDriver driver;
    private MultiplicationsPage multiplicationsPage;

    @BeforeMethod
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/multiplications.html");

        // Initialize page object
         multiplicationsPage = new MultiplicationsPage(driver);
    }

    @Test
    public void testMultiplication() {

        multiplicationsPage.enterNumbersAndMultiply(5, 7);
        String result = multiplicationsPage.getResultText();
        System.out.println(result);
     

    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
