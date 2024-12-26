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
        TestRunner.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        TestRunner.wait.until(ExpectedConditions.presenceOfElementLocated(By.id("celestialTable")));


        List<WebElement> tableRows = TestRunner.driver.findElements(By.tagName("tr"));
        for (int i = 0; i < tableRows.size(); i++) {
            System.out.println("This is what is inside of table rows: " + tableRows.get(i).toString());
            List<WebElement> tableCols = tableRows.get(i).findElements(By.tagName("td"));
            System.out.println("This is what is inside of table cols: " + tableCols.get(i).getText());
        }
        System.out.println("This is number of celestial Bodies after submitting valid data: " + TestRunner.homePage.getNumberOfCelestialRows());
        System.out.println("This is number of celestial Bodies variable within method submitting valid data: " + tableRows.size());


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
