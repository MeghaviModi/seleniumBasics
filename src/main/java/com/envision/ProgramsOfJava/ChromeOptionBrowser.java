package com.envision.ProgramsOfJava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;

import javax.sound.midi.Soundbank;

public class ChromeOptionBrowser {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions co=new ChromeOptions();
        co.setBrowserVersion("115");
        String browserpath= SeleniumManager.getInstance().getDriverPath(co,false).browserPath;
        String driverpath= SeleniumManager.getInstance().getDriverPath(co,false).driverPath;
        System.out.println(browserpath);
        System.out.println(driverpath);
        //co.setBinary("/Users/meghavimodi/IdeaProjects/seleniumtest/drivers/chrome-mac-x64");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        driver.quit();
    }
}
