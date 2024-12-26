#Part of User Story 5
Feature: As a user I want to remove planets from the Planetarium so I can correct my findings

    Background: Planet deletion starting actions
        Given   the user is on Home page
        When    user clicks on planet deletion

    #Happy Path 
    Scenario: Users can delete an existing planet
        When    user provides valid planet data
        Then    table will refresh
        And     page will be redirected to Home page

    Scenario Outline: Users can not delete a planet that does not exist
        When user provides invalid planet name "<planetName>"
        Then user should get a browser alert saying "<alert>"
        And page will be redirected to Home page

    Examples:
    |    planetName    |   alert   |
    |non existing planet|Invalid planet name|