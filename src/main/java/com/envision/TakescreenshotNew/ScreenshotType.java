package com.envision.TakescreenshotNew;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotType {
    public static void TakeScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot ts=(TakesScreenshot)driver;
        File scr=ts.getScreenshotAs(OutputType.FILE);
        File dec=new File("Screenshotes//"+getCurrentTime()+".png");
        FileUtils.copyFile(scr,dec);
    }

    public static String  getCurrentTime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_hh_mm_ss"));

    }
}
