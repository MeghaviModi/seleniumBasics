package TakeScreenShot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonUtility {
    public static  void TakeScreenShot(WebDriver driver) throws IOException {
        TakesScreenshot tss=(TakesScreenshot) driver;
        File scr=tss.getScreenshotAs(OutputType.FILE);
        File dest=new File("Screenshotes//"+getCurrentTime()+".png");

        FileUtils.copyFile(scr,dest);
    }

    public static void ashotScreenShot(WebDriver driver) throws IOException {
        //Screenshot screenshot=new AShot().takeScreenshot(driver);
        //ImageIO.write(screenshot.getImage(),"png",new File("Screenshotes//"+getCurrentTime()+".png"));
        Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(s.getImage(),"PNG",new File("Screenshotes//"+getCurrentTime()+".png"));


    }
    public static String getCurrentTime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_hh_mm_ss"));
    }
}
