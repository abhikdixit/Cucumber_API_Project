#Author: Abhinay Dixit
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
Feature: To Test Country details using Rest API Fucntionality

  @API_Regression @API_Smoke
  Scenario: Successful Search with Valid Input of Book ISBN Number
    Given User is on RestBookStore URI Home Page
    When User Enter the valid ISBN Number "9781449325862"
    Then verify Status code should be "200"
    And verify Title of the books return from server