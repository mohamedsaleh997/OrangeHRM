package com.testwebsite.pages;

import com.testwebsite.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {

    private final WebDriver driver;

    public AdminPage(WebDriver driver) {

        this.driver = driver ;
    }

    //Locators
    By recordRows = By.cssSelector("div[class='oxd-table-card']");
    By recordName = By.cssSelector("div[class='oxd-table-cell oxd-padding-cell']:nth-child(2)");
    By deleteIcon = By.cssSelector("i[class='oxd-icon bi-trash']");
    By addUserBtn = By.cssSelector("i[class='oxd-icon bi-plus oxd-button-icon']");
    By userNameSearch = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By searchBtn = By.cssSelector("button[type='submit']");
    By confirmDelete = By.cssSelector(".orangehrm-button-margin:last-child");
    By resetBtn = By.cssSelector(".oxd-button--ghost");


    //Actions
    public int numberOfRecords (){

        Waits.waitForElementsToBeVisible(driver ,recordRows);
       return  ElementActions.getListSize(driver ,recordRows);

    }


    public AdminPage deleteUser(){

        ElementActions.sendData(driver, userNameSearch , FakerUtil.getUserName());
        ElementActions.btnClick(driver , searchBtn);
        if(ElementActions.findElement(driver, recordName).getText()
                .equalsIgnoreCase(FakerUtil.getUserName())){

          ElementActions.btnClick(driver , deleteIcon);
          ElementActions.btnClick(driver , confirmDelete);
          ElementActions.btnClick(driver , resetBtn);
        }
        else {
            LoggerUtil.error("Selected Record Not Found To Delete");
        }


        return this;
    }

    public AddUserPage navigateToNewUserPage(){
        ElementActions.btnClick(driver ,addUserBtn);
        return new AddUserPage(driver);
    }


}


