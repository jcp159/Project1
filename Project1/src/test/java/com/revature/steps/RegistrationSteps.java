package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationSteps {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        TestRunner.loginPage.openLoginPage();
    }
    @When("the user clicks the register link")
    public void the_user_clicks_the_register_link() {
        TestRunner.loginPage.clickRegistrationLink();
    }
    @When("the user provides a valid username")
    public void the_user_provides_a_valid_username() {
        TestRunner.registrationPage.setUpUsername("Superman");
    }
    @And("the user provides a valid password")
    public void the_user_provides_a_valid_password() {
        TestRunner.registrationPage.setUpPassword("Krypton-was_2000");
    }
    @Then("the user submits the credentials")
    public void the_user_submits_the_credentials() {
        TestRunner.registrationPage.submit();
    }
    @And("the user should get a browser alert saying {string}")
    public void the_user_should_get_a_browser_alert_saying(String string) {
        /*TestRunner.registrationPage.setAlertMessage(string);
        String mes1 = TestRunner.registrationPage.returnAlertMessage();

        TestRunner.registrationPage.setAlertDriverText();
        String mes2 = TestRunner.registrationPage.returnAlertMessage();

        System.out.println("This is mes1: " + mes1);
        System.out.println("This is mes2: " + mes2);
        System.out.println("This is the string:" + string);
        Assert.assertEquals(mes1,mes2);
        //System.out.println("This is the string:" + string);*/
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals(string, alert.getText());
        alert.accept();

    }
    @And("the user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {
        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Account Creation")));
        Assert.assertEquals("Planetarium Login", TestRunner.driver.getTitle());
    }

    @When("the user provides a invalid username {string}")
    public void the_user_provides_a_invalid_username(String string) {
        TestRunner.registrationPage.setUpUsername(string);
    }
    @And("the user provides a invalid password {string}")
    public void the_user_provides_a_invalid_password(String string) {
        TestRunner.registrationPage.setUpPassword(string);
    }

    @And("user should stay on registration page")
    public void user_should_stay_on_registration_page() {
        Assert.assertEquals("Account Creation", TestRunner.driver.getTitle());
    }

}
