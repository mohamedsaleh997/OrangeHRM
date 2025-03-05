package com.testwebsite.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementActions {

    public static void sendData(WebDriver driver , By locator , String data){

        Waits.elementToBeVisible(driver , locator);
        driver.findElement(locator).sendKeys(data);
    }

    public static void btnClick(WebDriver driver , By locator){

        Waits.elementToBeClickable(driver , locator);

        driver.findElement(locator).click();
    }

    public static WebElement findElement (WebDriver driver , By locator){

        Waits.elementToBeVisible(driver,locator);
        return driver.findElement(locator);
    }

    public static String getmsgText (WebDriver driver ,By locator ){
        Waits.elementToBeVisible(driver , locator);
         return driver.findElement(locator).getText();

    }


  public static int getListSize(WebDriver driver , By locator){

        return driver.findElements(locator).size();
  }

  public static List<WebElement> getList(WebDriver driver ,  By locator , int elementsNumber){

          return Waits.waitForElementsToBeCounted(driver , locator ,  elementsNumber);
  }



}
