package com.testwebsite.drivers;

import com.testwebsite.utils.PropertiesManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {

    private static String driverType = PropertiesManager.webConfig.getProperty("browserName");

    public static WebDriver browserName (){

        switch (driverType.toLowerCase()){

            case "chrome" :
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                return new ChromeDriver(chromeOptions);

            case "firefox" :

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                return new FirefoxDriver(firefoxOptions);

             default :

                 throw new IllegalStateException ("Unknown Driver Type");
        }


    }
}
