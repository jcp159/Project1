package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MoonCreationSteps {
    @When("user clicks on moon creation link")
    public void user_clicks_on_moon_creation_link() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.loginPage.setUpLoggedInUser();
        TestRunner.wait.until(ExpectedConditions.titleIs("Home"));
        TestRunner.homePage.selectMoonElement();
    }

    @When("user provides valid moon data")
    public void user_provides_valid_moon_data() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.setUpValidMoonCredentials();
    }


    @When("user provides invalid moon name {string}")
    public void user_provides_invalid_moon_name(String string) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.setUpMoonName(string);
        TestRunner.homePage.setUpValidOrbitalPlanetId();
        TestRunner.homePage.submitMoon();
    }

    @When("user provides invalid owning planet {string}")
    public void user_provides_invalid_owning_planet(String string) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.setUpMoonName();
        TestRunner.homePage.setUpOrbitalPlanetId();
        TestRunner.homePage.submitMoon();
    }

    @When("user provides invalid moon file type {string}")
    public void user_provides_invalid_moon_file_type(String string) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.setUpMoonFileInput();
        TestRunner.homePage.submitMoon();
    }

}
