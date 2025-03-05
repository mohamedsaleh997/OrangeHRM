package Cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepDefinition  {

    public StepDefinition() {

    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Hooks.loginPage.landing_On_LoginPage_Assertion();
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        Hooks.loginPage.enterUserName()
                .enterPassword();
    }

    @And("clicks the login button")
    public void clicks_the_login_button() {
        Hooks.loginPage.loginBtn();
    }

    @Then("the user should be redirected to the admin page")
    public void the_user_should_be_redirected_to_the_admin_page() {
        Assert.assertTrue(Hooks.homePage.isOnHomePage());
    }

    @Given("the user is on the admin page")
    public void the_user_is_on_the_admin_page() {
        Hooks.homePage.navigateToAdminPage();
    }

    @When("the user navigates to the Add User page")
    public void the_user_navigates_to_the_add_user_page() {
        Hooks.recordsBefore = Hooks.adminPage.numberOfRecords();
        Hooks.adminPage.navigateToNewUserPage();
    }

    @And("enters user details")
    public void enters_user_details() {
        Hooks.addUserPage.enterUserRole()
                .enterStatus()
                .enterEmployeeName()
                .enterUserName()
                .enterPassword()
                .enterPasswordConfirmation();
    }

    @And("clicks the save button")
    public void clicks_the_save_button() {
        Hooks.addUserPage.clickSaveBtn();
    }

    @Then("the new user should be added successfully")
    public void the_new_user_should_be_added_successfully() {
        Hooks.recordsAfter =Hooks.adminPage.numberOfRecords();
        Assert.assertEquals(Hooks.recordsBefore + 1, Hooks.recordsAfter);
    }

    @When("the user deletes an existing user")
    public void the_user_deletes_an_existing_user() {
        Hooks.recordsBefore = Hooks.adminPage.numberOfRecords();
        Hooks.adminPage.deleteUser();
    }

    @Then("the user should be removed successfully")
    public void the_user_should_be_removed_successfully() {
        Hooks.recordsAfter = Hooks.adminPage.numberOfRecords();
        Assert.assertEquals(Hooks.recordsBefore - 1, Hooks.recordsAfter);
    }
}
