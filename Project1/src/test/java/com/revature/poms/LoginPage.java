package com.revature.poms;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "usernameInput")
    private WebElement usernameInput;

    @FindBy(id = "passwordInput")
    private WebElement passwordInput;

    @FindBy(xpath = "//form/input[3]")
    private WebElement loginButton;

    @FindBy(tagName = "a")
    private WebElement registrationLink;

    @FindBy(tagName = "h1")
    private WebElement loginTitle;

    public void clickRegistrationLink() {
        registrationLink.click();
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void setUpLoggedInUser() {
        driver.get("http://localhost:8080/");
        usernameInput.sendKeys("Batman");
        passwordInput.sendKeys("Iamthenight1939");
        loginButton.submit();
    }

    public void setUsernameInput(String username) {
        usernameInput.sendKeys(username);
    }

    public void setPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginbutton() {
        loginButton.submit();
    }

    public void openLoginPage(){
        driver.get("http://localhost:8080/");
    }

    public void openRegistrationPage() {
        driver.get("http://localhost:8080/register");
    }

    public String returnLoginTitle() {
        return loginTitle.getText();
    }


    }







