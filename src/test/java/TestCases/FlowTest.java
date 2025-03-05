package TestCases;

import base.BaseTest;
import com.testwebsite.listeners.TestngListener;
import com.testwebsite.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestngListener.class)
public class FlowTest extends BaseTest {


    @Test(priority = 1)
    public void loginTest () throws InterruptedException {
        loginPage.enterUserName()
                .enterPassword()
                .loginBtn();
    }



    @Test(priority = 2 , dependsOnMethods = "loginTest")
    public void addUserCheck(){

        new HomePage(driver).navigateToAdminPage();
        int recordsNumber=  adminPage.numberOfRecords();
        adminPage.navigateToNewUserPage()
                .enterUserRole()
                .enterStatus()
                .enterEmployeeName()
                .enterUserName()
                .enterPassword()
                .enterPasswordConfirmation()
                .clickSaveBtn();
        int newRecordsNumber=  adminPage.numberOfRecords();
        Assert.assertEquals(newRecordsNumber , recordsNumber+1, " Add User Failed , Records Are Not Equal !");
        }



        @Test (priority = 3 , dependsOnMethods = "addUserCheck")
        public void deleteUserCheck(){
        int recordsNumber=  adminPage.numberOfRecords();
        adminPage.deleteUser();
        int recordsAfterDelete = adminPage.numberOfRecords();
        Assert.assertEquals(recordsNumber-1 , recordsAfterDelete, "Delete User Failed , Records Are Not Equal !");

        }

    }

