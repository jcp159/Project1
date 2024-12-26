package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class PlanetCreationSteps {
    @Given("the user is on Home page")
    public void the_user_is_on_Home_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.loginPage.setUpLoggedInUser();
    }
    @When("user clicks on planet creation link")
    public void user_clicks_on_planet_creation_link() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.selectPlanetElement();
    }

    @When("user provides valid data")
    public void user_provides_valid_data() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.setUpValidPlanetCredentials();
    }

    @Then("the table will refresh")
    public void the_table_will_refresh() {
        TestRunner.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/table/tbody/tr[6]")));
        //TestRunner.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        //List<WebElement> tableRows = TestRunner.driver.findElements(By.xpath("html/body/div[2]/table/tbody/tr[4]"));
        String expectedPlanetInfo = "planet 3 Pluto 1";
        String actualPlanetInfo = TestRunner.homePage.returnUpdateRowsForPlanetCreation().get(0).getText();
        System.out.println("this is expected planet info " + expectedPlanetInfo);
        System.out.println("this is actual planet info " + actualPlanetInfo);
        Assert.assertEquals(expectedPlanetInfo,actualPlanetInfo);
    }


    @When("user provides invalid name {string}")
    public void user_provides_invalid_name(String string) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.setUpPlanetName(string);
        TestRunner.homePage.submitPlanet();
    }

    @Then("user should get a browser alert saying {string}")
    public void user_should_get_a_browser_alert_saying(String string) {
        // Write code here that turns the phrase above into concrete actions
        /*TestRunner.homePage.setAlertMessage(string);
        String mes1 = TestRunner.homePage.returnAlertMessage();
        System.out.println("This is mes1: " + mes1);

        TestRunner.homePage.setAlertDriverText();
        String mes2 = TestRunner.homePage.returnAlertMessage();
        System.out.println("This is mes2: " + mes2);
        Assert.assertEquals(mes1,mes2);*/
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals(string, alert.getText());
        alert.accept();
    }

    @Then("user will be redirected to Home page")
    public void user_will_be_redirected_to_Home_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("This is the greeting on the homepage: " + TestRunner.homePage.getHomePageGreeting());
    }

    @When("user provides invalid file type {string}")
    public void user_provides_invalid_file_type(String string) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.setUpPlanetName();
        TestRunner.homePage.setUpFileInput();
        TestRunner.homePage.submitPlanet();
    }
}
