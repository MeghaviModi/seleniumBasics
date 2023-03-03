package TakeScreenShot;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class TakeScreenShotRunner {
    @Test
    public void testToTakeScreenShot() throws IOException {
        WebDriver driver =BrowserFactory.OpneBrowser("chrome");
        BrowserFactory.OpenBroserApplication();
        //CommonUtility.TakeScreenShot(driver);
        CommonUtility.ashotScreenShot(driver);
        BrowserFactory.closeBrowser();
        BrowserFactory.quitBrowser();
    }
}
