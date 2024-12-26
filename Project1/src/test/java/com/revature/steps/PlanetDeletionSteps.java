package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

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

        TestRunner.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/table/tbody/tr[3]")));
        //TestRunner.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //List<WebElement> tableRows = TestRunner.driver.findElements(By.xpath("html/body/div[2]/table/tbody/tr[2]"));
        String expectedPlanetInfo = "planet 2 Mars 1";
        String actualPlanetInfo = TestRunner.homePage.returnUpdatedRowsForPlanetDeletion().get(0).getText();
        System.out.println("this is expected planet info " + expectedPlanetInfo);
        System.out.println("this is actual planet info " + actualPlanetInfo);
        Assert.assertEquals(expectedPlanetInfo,actualPlanetInfo);


    }



    @When("user provides invalid planet name {string}")
    public void user_provides_invalid_planet_name(String string) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.setUpNameToBeDeleted(string);
        TestRunner.homePage.clickDeleteButton();
    }
}
