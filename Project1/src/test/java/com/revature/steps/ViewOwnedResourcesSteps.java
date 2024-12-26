package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ViewOwnedResourcesSteps {
    @Given("the user login is successful")
    public void the_user_login_is_successful() {
        TestRunner.loginPage.setUpLoggedInUser();
    }

    @Then("user should be at home page and will be able to see planets and moons")
    public void user_should_be_at_home_page_and_will_be_able_to_see_planets_and_moons() {
        try {
            TestRunner.wait.until(ExpectedConditions.titleIs("Home"));
            Assert.assertEquals(String.format(
                            "Expected 'Welcome to the Home Page Batman', but got %s",
                            TestRunner.homePage.getHomePageGreeting()
                    ),
                    "Welcome to the Home Page Batman",
                    TestRunner.homePage.getHomePageGreeting());
            Assert.assertEquals(4, TestRunner.homePage.getNumberOfCelestialRows());
        } finally {
            TestRunner.homePage.logout();
        }

    }

    @Given("the user login is unsuccessful")
    public void the_user_login_is_unsuccessful() {
        TestRunner.loginPage.openLoginPage();
        TestRunner.homePage.tryToAccessHomePageDirectly();
    }

    @Then("user should not be able to access the home page")
    public void user_should_not_be_able_to_access_the_home_page() {
        Assert.assertNotEquals("Home", TestRunner.driver.getTitle());
    }
}
