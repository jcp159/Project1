#Part of User Story 4
Feature: As a user I want to add new planets to the Planetarium so I can update my findings

    Background: Planet creation starting actions
        Given   the user is on Home page
        When    user clicks on planet creation link

    #Happy Path
    Scenario: Users can create a planet with valid credentials
        When    user provides valid data
        Then    the table will refresh
    
    #Sad Path 
    Scenario Outline: Users can not create a planet with invalid planet name
        When    user provides invalid name "<name>"
        Then    user should get a browser alert saying "<alert>"
        And     user will be redirected to Home page    

    Examples: 
    |           name                |       alert       |
    |This_is_my_planet_I_created_pol|Invalid planet name|	
    |                               |Invalid planet name|	
    |           !planet!            |Invalid planet name|	
    |            Earth              |Invalid planet name|

    Scenario Outline: Users can not create a planet with invalid file type
        When    user provides invalid file type "<filetype>"
        Then    user should get a browser alert saying "<alert>"
        And     user will be redirected to Home page	

    Examples:
    |filetype                           |        alert                       |
    |any other file type than PNG & JPEG|Invalid file type for planet picture|	
	
