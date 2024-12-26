package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlanetDeletionSteps {
    @When("user clicks on planet deletion")
    public void user_clicks_on_planet_deletion() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.selectPlanetElement();
    }

    @When("user provides valid planet data")
    public void user_provides_valid_planet_data() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.setUpNameToBeDeleted("Earth");
        TestRunner.homePage.clickDeleteButton();
    }

    @Then("table will refresh")
    public void table_will_refresh() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.wait.until(ExpectedConditions.titleIs("Home"));
    }

    @Then("page will be redirected to Home page")
    public void page_will_be_redirected_to_Home_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("This is home title: " + TestRunner.homePage.getHomeTitle());
        TestRunner.homePage.getHomeTitle();
    }

    @When("user provides invalid planet name {string}")
    public void user_provides_invalid_planet_name(String string) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.setUpNameToBeDeleted(string);
        TestRunner.homePage.clickDeleteButton();
    }
}
