package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MoonDeletionSteps {
    @Then("user clicks delete button")
    public void user_clicks_delete_button() {
        TestRunner.homePage.selectMoonElement();
    }

    @When("user provides valid moon data to be deleted")
    public void user_provides_valid_moon_data_to_be_deleted() {
        TestRunner.homePage.setUpNameToBeDeleted("Luna");
        TestRunner.homePage.clickDeleteButton();
    }

    @When("user provides invalid moon name to be deleted {string}")
    public void user_provides_invalid_moon_name_to_be_deleted(String string) {
        TestRunner.homePage.setUpNameToBeDeleted(string);
        TestRunner.homePage.clickDeleteButton();
    }
}
