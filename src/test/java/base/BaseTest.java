package base;

import com.testwebsite.drivers.DriverManager;
import com.testwebsite.pages.AdminPage;
import com.testwebsite.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public WebDriver driver ;
    public LoginPage loginPage ;
    public AdminPage adminPage;

    @BeforeClass
    public void setup(){
        driver = DriverManager.createInstance();
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
