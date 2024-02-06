package AutomationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MultiplicationsPage {
    private WebDriver driver;

    public MultiplicationsPage(WebDriver driver) {
        this.driver = driver;
    }


    private WebElement getFirstInputField() {
        return driver.findElement(By.id("value1"));
    }

    private WebElement getSecondInputField() {
        return driver.findElement(By.id("value2"));
    }

    private WebElement getMultiplyButton() {
        return driver.findElement(By.id("go"));
    }

    private WebElement getResult() {
        return driver.findElement(By.id("result"));
    }

    private WebElement getErrorMessage() {
        return driver.findElement(By.id("errorMessage"));
    }

    public void enterNumbersAndMultiply(int num1, int num2) {
        getFirstInputField().sendKeys(String.valueOf(num1));
        getSecondInputField().sendKeys(String.valueOf(num2));
        getMultiplyButton().click();
    }

    public String getResultText() {
        return getResult().getText();
    }

    public String getErrorMessageText() {
        return getErrorMessage().getText();
    }
}
