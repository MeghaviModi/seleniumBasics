package com.envision.TakescreenshotNew;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TakeScreenShotRunner {
    @Test
    public  void TestTakeScreenShot() throws IOException {
        WebDriver driver=BrowserFile.getBrowser("chrome");
        BrowserFile.getApplication();
        ScreenshotType.TakeScreenshot(driver);
        BrowserFile.getSearch("Java Tutorial");
        BrowserFile.ClickButton();
        BrowserFile.teardownBrowser();
    }
}
