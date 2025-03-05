package com.testwebsite.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Waits {

    //Wait For Element To be Present

    public static WebElement elementToBePresent(WebDriver driver, By locator) {

        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> driver1.findElement(locator));
    }

    //Wait for Element to be Visible
    public static WebElement elementToBeVisible(WebDriver driver, By locator) {

        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 ->

                {
                    WebElement element = elementToBePresent(driver, locator);
                    return element.isDisplayed() ? element : null;

                });

    }


    public static void elementToBeClickable(WebDriver driver, By locator) {

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver1 ->

                {
                    WebElement element = elementToBeVisible(driver, locator);
                    return element.isEnabled() ? element : null;

                });


    }

    public static void waitForUrl(WebDriver driver, String url) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains(url));
    }


    public static void waitForElementsToBePresent(WebDriver driver, By locator) {

         new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public static List<WebElement> waitForElementsToBeVisible(WebDriver driver, By locator ){

        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static List<WebElement> waitForElementsToBeCounted(WebDriver driver, By locator , int elementsNumber) {

        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(locator ,  elementsNumber));
    }

}