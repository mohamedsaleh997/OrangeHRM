package com.testwebsite.pages;

import com.testwebsite.utils.ElementActions;
import com.testwebsite.utils.FakerUtil;
import com.testwebsite.utils.JsonUtil;
import com.testwebsite.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class AddUserPage {

    private final WebDriver driver ;

    public AddUserPage (WebDriver driver){

        this.driver=driver;
    }

    //Locators

    By userRole = By.xpath("(//div[@class='oxd-select-wrapper'])[1]");
    By dropDown = By.cssSelector("div[role='listbox']");
    By dropDwonOptions = By.cssSelector("div[role='listbox'] div[role='option']");
    By status = By.xpath("(//div[@class='oxd-select-wrapper'])[2]");
    By employeeName = By.cssSelector("input[placeholder='Type for hints...']");
    By userName = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By password = By.xpath("(//input[@type='password'])[1]");
    By confirmPassword = By.xpath("(//input[@type='password'])[2]");
    By saveBtn = By.cssSelector("button[type='submit']");


    //Actions

    public AddUserPage enterUserRole (){
        ElementActions.btnClick(driver , userRole);
        List<WebElement> options = ElementActions.getList(driver , dropDwonOptions , 1);
        WebElement option = options.stream().filter(opt -> opt.getText().
                equalsIgnoreCase(JsonUtil.getJsonProperty("role"))).findFirst().orElseThrow(()->{
            LoggerUtil.error("Error in Role Field: ");
            return new NoSuchElementException("Role Not Found" + JsonUtil.getJsonProperty("role"));
        });
        option.click();
        return this;
    }

    public AddUserPage enterStatus (){
        ElementActions.btnClick(driver , this.status);
        List<WebElement> options = ElementActions.getList(driver , dropDwonOptions , 1);
        WebElement option = options.stream().filter(opt -> opt.getText().
                equalsIgnoreCase(JsonUtil.getJsonProperty("status"))).findFirst().orElseThrow(()->{
                LoggerUtil.error("Error in Status Field: ");
                return new NoSuchElementException("Status Not Found" + JsonUtil.getJsonProperty("status"));
        });
                option.click();

        return this;

    }

    public AddUserPage enterEmployeeName ()  {
        ElementActions.btnClick(driver,this.employeeName);
        ElementActions.sendData(driver , this.employeeName , JsonUtil.getJsonProperty("employeeName"));
        List<WebElement> options = ElementActions.getList(driver ,  dropDwonOptions , 1);
        WebElement option = options.stream().filter(opt -> opt.getText().
                equalsIgnoreCase(JsonUtil.getJsonProperty("employeeName"))).findFirst().orElseThrow(()->{
            LoggerUtil.error("Error in EmployeeName Field: ");
            return new NoSuchElementException("Name Not Found" + JsonUtil.getJsonProperty("employeeName"));
        });
        option.click();
           return this;
    }

    public AddUserPage enterUserName (){
        ElementActions.sendData(driver , this.userName , FakerUtil.getUserName());
        return this;}

    public AddUserPage enterPassword (){
        ElementActions.sendData(driver , this.password , JsonUtil.getJsonProperty("password"));
        return this;}

    public AddUserPage enterPasswordConfirmation (){
        ElementActions.sendData(driver , this.confirmPassword , JsonUtil.getJsonProperty("passwordConfirm"));
        return this;}

    public AddUserPage clickSaveBtn (){
        ElementActions.btnClick(driver , saveBtn);
        return this;}

}
