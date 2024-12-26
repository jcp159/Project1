#Part of User Story 5
Feature: As a user I want to remove moons from the Planetarium so I can correct my findings

    Background: Moon deletion starting actions
        When    the user is on Home page
        Then    user clicks delete button

    #Happy Path
    Scenario: Users can delete an existing moon 
        When    user provides valid moon data to be deleted
        And     table will refresh with moon deleted

    #Sad Path
    Scenario Outline: Users can not delete a moon that does not exist
        When    user provides invalid moon name to be deleted "<moonName>"
        Then    user should get a browser alert saying "<alert>"

    Examples:
    |      moonName   |        alert      |
    |non existing moon|  Invalid moon name|