package com.testwebsite.pages;

import com.testwebsite.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final  WebDriver driver ;

    //Driver Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    By adminTab = By.cssSelector("a[href='/web/index.php/admin/viewAdminModule']");

    //Actions
    public HomePage navigateToAdminPage(){
        ElementActions.btnClick(driver , adminTab);
        return this;}

    //Assertions
    public boolean isOnHomePage(){
        boolean dashboard = driver.getCurrentUrl().contains("dashboard");
        return dashboard;
    }

}
