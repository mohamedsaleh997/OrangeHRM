package com.testwebsite.utils;

import org.openqa.selenium.WebDriver;

public class BrowserActions {

    public static void  getUrl(WebDriver driver , String url){

        driver.get(url);

    }

    public static String getCurrentUrl(WebDriver driver){

       return driver.getCurrentUrl();
    }
}
