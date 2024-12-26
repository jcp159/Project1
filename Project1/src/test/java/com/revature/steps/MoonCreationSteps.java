package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

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

    @Then("the table will refresh with new moon added")
    public void the_table_will_refresh_with_new_moon_added() {
        TestRunner.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/table/tbody/tr[6]")));
        //TestRunner.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        //List<WebElement> tableRows = TestRunner.driver.findElements(By.xpath("html/body/div[2]/table/tbody/tr[6]"));
        String expectedMoonInfo = "moon 3 Big Moon 1";
        String actualMoonInfo = TestRunner.homePage.returnUpdatedRowsForMoonCreation().get(0).getText();
        System.out.println("this is expected moon info " + expectedMoonInfo);
        System.out.println("this is actual moon info " + actualMoonInfo);
        Assert.assertEquals(expectedMoonInfo,actualMoonInfo);
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
