package com.envision.Java.pages;

import com.envision.Java.core.BaseTest;
import org.testng.annotations.Test;

public class TestRunner extends BaseTest {
    @Test
    public void TestRunnerRun(){
        HomePage homePage=new HomePage(driver);
        homePage.launchApplictioUrl("https://www.amazon.ca/");
    }
}
