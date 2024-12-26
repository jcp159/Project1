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

    @When("table will refresh with moon deleted")
    public void table_will_refresh_with_moon_deleted() {
        TestRunner.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/table/tbody/tr[4]")));
        //TestRunner.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //List<WebElement> tableRows = TestRunner.driver.findElements(By.xpath("html/body/div[2]/table/tbody/tr[4]"));
        String expectedMoonInfo = "moon 2 Titan 2";
        String actualMoonInfo = TestRunner.homePage.returnUpdatedRowsForMoonDeletion().get(0).getText();
        System.out.println("this is expected planet info " + expectedMoonInfo);
        System.out.println("this is actual planet info " + actualMoonInfo);
        Assert.assertEquals(expectedMoonInfo,actualMoonInfo);
    }

    @When("user provides invalid moon name to be deleted {string}")
    public void user_provides_invalid_moon_name_to_be_deleted(String string) {
        TestRunner.homePage.setUpNameToBeDeleted(string);
        TestRunner.homePage.clickDeleteButton();
    }
}
