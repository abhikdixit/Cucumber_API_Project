#Author: Abhi
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
@sanity
Feature: To Test TestComplete Sign On Functionality

  Scenario: Successful Login with Valid Credentials in TestComplete App
    Given User has Launched Browser in TestComplete
    When User Navigate to Sign On Page in TestComplete
    And User enters username and password in TestComplete
    And User Click on Login Button in TestComplete
    Then User should logged in and WebOrders page should display in TestComplete

  Scenario: Successful LogOut
    When User LogOut from the Application
    Then Message displayed LogOut Successfully
