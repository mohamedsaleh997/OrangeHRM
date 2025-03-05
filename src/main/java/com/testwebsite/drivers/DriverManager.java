package com.testwebsite.drivers;

import org.openqa.selenium.WebDriver;

import static com.testwebsite.utils.PropertiesManager.intializeConfig;
import static com.testwebsite.utils.PropertiesManager.webConfig;
import static org.testng.Assert.fail;


public class DriverManager {

    public static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();


    public static WebDriver createInstance() {
        WebDriver driver = BrowserFactory.browserName();
        setDriver(driver);

        if (!webConfig.getProperty("BaseUrl").isEmpty()){
            driverThreadLocal.get().navigate().to(webConfig.getProperty("BaseUrl"));
        }
        return getDriver();
    }


    public static WebDriver getDriver () {
        if (driverThreadLocal.get() == null){
            fail("Driver is Null");
        }
         return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }
}
