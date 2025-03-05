package com.testwebsite.listeners;

import com.testwebsite.drivers.DriverManager;
import com.testwebsite.utils.LoggerUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import static com.testwebsite.utils.PropertiesManager.intializeConfig;


public class TestngListener implements ITestListener , IExecutionListener {

    File logs = new File("logs");
    File screenshots = new File ("screenshot");

    @Override
    public void onExecutionStart() {
          LoggerUtil.info("****  Start Of The Execution  ****");
          deleteFiles(logs);
          deleteFiles(screenshots);
          intializeConfig();
    }

    @Override
    public void onExecutionFinish() {
        LoggerUtil.info("**** Execution Finished  ****");
    }

    @Override
    public void onTestStart(ITestResult result) {
        LoggerUtil.info("Test " + result.getName() + " Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LoggerUtil.info("Test " + result.getName() + " Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LoggerUtil.error("Test " + result.getName() + " Failed");
        LoggerUtil.error("Taking Screenshot");
        Object testClass = result.getInstance();
        WebDriver driver = DriverManager.getDriver();
        if (driver != null){
            captureScreenShot(driver , result.getName());
        }

    }

    public void captureScreenShot(WebDriver driver , String testName){
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File des = new File("screenshot/" + testName + ".png");
        try{
            FileUtils.copyFile(src , des);
            LoggerUtil.info("screenshot to the failed test saved to " + des.getAbsolutePath());
        }
        catch (IOException e){
            LoggerUtil.error(e.getMessage());
        }


    }

    public static void deleteFiles(File file){
        try{FileUtils.deleteDirectory(file);
        }
        catch (IOException e){
            LoggerUtil.error(e.getMessage());
        }
}}
