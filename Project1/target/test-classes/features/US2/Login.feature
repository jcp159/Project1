#User Story 2
Feature: User Login
    As a user I want to securely access my account so I can interact with the Planetarium in a secure environment

    Background: Login Starting Actions
        Given   the user is on the login page

    #Happy Path
    Scenario: Users can login with valid credentials
        When    the user provides a valid username for login page
        And     the user provides a valid password for login page
        Then    the user submits the credentials for login page
        And     the user should be redirected to Home page

    #Sad Path
    Scenario Outline: Users can not login with invalid credentials
        When    the user provides a invalid username "<username>"
        And     the user provides a invalid password "<password>"
        And     the user submits the credentials
        Then    the user should get a browser alert saying "<alert>"
        And     the user should be redirected to login page

        Examples:
            |username|	password	    |      alert    |
            |Batman	 |	b0Ts            |Invalid credentials|
            |Robin   |	Iamthenight1939	|Invalid credentials|
            |Robin   |	b0Ts            |Invalid credentials|