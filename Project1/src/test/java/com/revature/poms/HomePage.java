package com.revature.poms;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    @FindBy(id = "greeting")
    private WebElement greetingHeader;

    @FindBy(xpath = "html/head//title")
    private WebElement title;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(id ="locationSelect")
    private WebElement selectElement;

    @FindBy(id = "planetNameInput")
    private WebElement planetNameInput;

    @FindBy(xpath = "html/body/div/div[2]/button")
    private WebElement planetSubmitButton;

    @FindBy(id = "planetImageInput")
    private WebElement fileInput;

    @FindBy(id = "moonNameInput")
    private WebElement moonNameInput;

    @FindBy(id = "orbitedPlanetInput")
    private WebElement orbitedPlanetInput;

    @FindBy(id = "moonImageInput")
    private WebElement fileMoonInput;

    @FindBy(xpath = "html/body/div[1]/div[2]/button")
    private WebElement moonSubmitButton;

    @FindBy(xpath = "//*[@id=\"celestialTable\"]/tbody/tr[7]/td[3]")
    private WebElement newMoon;

    @FindBy(id = "deleteInput")
    private  WebElement deleteInput;

    @FindBy(id = "deleteButton")
    private WebElement deleteButton;



    private Alert alert;

    private String alertMessage;


    @FindBy(tagName = "tr")
    private List<WebElement> tableRows;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getHomePageGreeting() {
        return greetingHeader.getText();
    }

    public String getHomeTitle() {
        return title.getText();
    }

    public int getNumberOfCelestialRows(){
        return tableRows.size() - 1;
    }

    public List<WebElement> returnTableRows(){
        return tableRows;
    }



    public void tryToAccessHomePageDirectly(){
        driver.get("http://localhost:8080/planetarium");
    }

    public void selectPlanetElement() {
        Select select = new Select(selectElement);
        select.selectByValue("planet");
    }

    public void selectMoonElement() {
        Select select = new Select(selectElement);
        select.selectByValue("moon");
    }

    public void logout() {
        logoutButton.click();
    }

    public void setUpValidPlanetCredentials () {
        planetNameInput.sendKeys("Pluto");
        fileInput.sendKeys("C:\\Users\\Owner\\Desktop\\RevatureProjects\\Project1\\src\\test\\resources\\Celestial-Images\\planet-1.jpg");
        planetSubmitButton.click();
    }

    public void setUpValidMoonCredentials() {
        moonNameInput.sendKeys("Big Moon");
        orbitedPlanetInput.sendKeys("1");
        fileMoonInput.sendKeys("C:\\Users\\Owner\\Desktop\\RevatureProjects\\Project1\\src\\test\\resources\\Celestial-Images\\moon-1.jpg");
        moonSubmitButton.click();
    }

    public void submitPlanet(){
        planetSubmitButton.click();
    }

    public void setUpFileInput(){
        fileInput.sendKeys("C:\\Users\\Owner\\Desktop\\RevatureProjects\\Project1\\src\\test\\resources\\Celestial-Images\\Trick question on selenium.txt");
    }

    public void setUpPlanetName(){
        planetNameInput.sendKeys("Luna");
    }

    public void setUpPlanetName(String name) {
        planetNameInput.sendKeys(name);
    }

    public void submitMoon() {
        moonSubmitButton.click();
    }

    public void setUpMoonName(String name) {
        moonNameInput.sendKeys(name);
    }

    public void setUpMoonName() {
        moonNameInput.sendKeys("Little Moon");
    }

    public void setUpOrbitalPlanetId() {
        orbitedPlanetInput.sendKeys("999");
    }

    public void setUpValidOrbitalPlanetId(){
        orbitedPlanetInput.sendKeys("1");
    }

    public String newCreatedMoon() {
        return newMoon.getText();
    }

    public void setUpMoonFileInput(){
        moonNameInput.sendKeys("Mars Moon");
        orbitedPlanetInput.sendKeys("1");
        fileMoonInput.sendKeys("C:\\Users\\Owner\\Desktop\\RevatureProjects\\Project1\\src\\test\\resources\\Celestial-Images\\Trick question on selenium.txt");
    }


    //Deletion Operations
    public void setUpNameToBeDeleted(String name) {
        deleteInput.sendKeys(name);

    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

}
