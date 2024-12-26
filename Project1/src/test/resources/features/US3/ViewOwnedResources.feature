#User Story 3
Feature:    View User Planets and Moons
    As a user I want to see my planets and moons added to the Planetarium so I can track my findings

    Scenario: Login should allow for viewing owned resources
        Given   the user login is successful
        Then    user should be at home page and will be able to see planets and moons

    Scenario: Users not logged in should not be able to view home page and its resources
        Given   the user login is unsuccessful
        Then    user should not be able to access the home page