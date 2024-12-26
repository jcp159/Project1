#Part of User Story 4
Feature: As a user I want to add new moons to the Planetarium so I can update my findings

    Background: Moon creation starting actions
        When user clicks on moon creation link

    #Happy Path
    Scenario: As a user I want to add new moons to the Planetarium so I can update my findings
    When    user provides valid moon data
    Then    the table will refresh

    #Sad Path  
    Scenario Outline: Users can not create a moon with invalid moon name
    When    user provides invalid moon name "<name>"
    Then    user should get a browser alert saying "<alert>"

    Examples:   
    |           name                |         alert         |
    |This_is_my_moon_I_created______|  Invalid moon name	|
    |                               |  Invalid moon name	|
    |            !moon!             |  Invalid moon name	|
    |             Luna              |  invalid moon name	|

    Scenario Outline: Users can not create a moon with a invalid planet ID
        When    user provides invalid owning planet "<planetID>"
        Then    user should get a browser alert saying "<alert>"

    Examples:
    |planetID |       alert       |
    |   IPN1  | Invalid planet id |
    |   IPN2  | Invalid planet id |
    |   IPN3  | Invalid planet id |
    |   IPN4  | Invalid planet id |

    Scenario Outline: Users can not create a moon with a invalid file type
        When    user provides invalid moon file type "<filetype>"
        Then    user should get a browser alert saying "<alert>"
        And     user will be redirected to Home page

    Examples:
    |             filetype              |       alert                      |
    |any other file type than PNG & JPEG|Invalid file type for moon picture|	