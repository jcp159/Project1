package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginSteps {

    @When("the user provides a valid username for login page")
    public void the_user_provides_a_valid_username_for_login_page() {
        TestRunner.loginPage.setUsernameInput("Batman");
    }

    @And("the user provides a valid password for login page")
    public void the_user_provides_a_valid_password_for_login_page() {
        TestRunner.loginPage.setPasswordInput("Iamthenight1939");
    }
    @Then("the user submits the credentials for login page")
    public void the_user_submits_the_credentials_for_login_page() {
        TestRunner.loginPage.clickLoginbutton();
    }

    @And("the user should be redirected to Home page")
    public void the_user_should_be_redirected_to_Home_page() {
        // Write code here that turns the phrase above into concrete actions
        //TestRunner.loginPage.openLoginPage();
        TestRunner.wait.until(ExpectedConditions.titleIs("Home"));
        Assert.assertEquals(String.format(
                        "Expected 'Welcome to the Home Page Batman', but got %s",
                        TestRunner.homePage.getHomePageGreeting()
                ),
                "Welcome to the Home Page Batman",
                TestRunner.homePage.getHomePageGreeting());

    }

    @And("the user should be redirected to login page")
    public void the_user_should_be_redirected_to_login_page() {
        //TestRunner.loginPage.openLoginPage();
        TestRunner.wait.until(ExpectedConditions.titleIs("Planetarium Login"));
        //System.out.println("this is title of login page: " + TestRunner.loginPage.returnLoginTitle());
        Assert.assertEquals("Planetarium Login", TestRunner.loginPage.returnLoginTitle());
    }
}
