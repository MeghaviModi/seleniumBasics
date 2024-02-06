package com.envision.Java.pages;

import com.envision.Java.core.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    public HomePage launchApplictioUrl(String url){
        urlLunch(url);
        return this;
    }



}
