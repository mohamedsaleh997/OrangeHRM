package com.testwebsite.pages;

import com.testwebsite.utils.BrowserActions;
import com.testwebsite.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    //Driver Constructor
    private final WebDriver driver;

    public LoginPage (WebDriver driver){

        this.driver = driver ;
    }

    //Locators
    private final By userName = By.cssSelector("input[name='username']");
    private final By password = By.cssSelector("input[name='password']");
    private final  By loginBtn = By.cssSelector("button[type='submit']");


    //Actions
    public LoginPage navigateToLoginPage(String url){
        BrowserActions.getUrl(driver , url);
        return this;
    }

    public LoginPage enterUserName () {
        ElementActions.sendData(driver , this.userName , "Admin");
        return this;
       }

    public LoginPage enterPassword (){
        ElementActions.sendData(driver , this.password , "admin123");
        return this;
    }
    public HomePage loginBtn(){
        ElementActions.btnClick(driver , this.loginBtn);
        return new HomePage(driver);
    }

    //Assertions
    public void landing_On_LoginPage_Assertion(){
        Assert.assertTrue(driver.getCurrentUrl().contains("opensource-demo"));
    }

}
