package Cucumber;

import com.testwebsite.drivers.DriverManager;
import com.testwebsite.pages.AddUserPage;
import com.testwebsite.pages.AdminPage;
import com.testwebsite.pages.HomePage;
import com.testwebsite.pages.LoginPage;
import com.testwebsite.utils.PropertiesManager;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static  WebDriver driver ;
    public static  LoginPage loginPage;
    public static HomePage homePage;
    public static AdminPage adminPage;
    public static AddUserPage addUserPage;
    public static int recordsBefore, recordsAfter;

    @BeforeAll
    public static void before_all() {
        if (driver == null) {
            PropertiesManager.intializeConfig();
            driver = DriverManager.createInstance();
            loginPage = new LoginPage(driver);
            homePage = new HomePage(driver);
            adminPage = new AdminPage(driver);
            addUserPage = new AddUserPage(driver);

        }
    }

    @AfterAll
    public static void after_all() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
}}
