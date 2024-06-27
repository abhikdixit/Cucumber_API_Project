#Author: Abhinay Dixit
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
Feature: To Login and Get the Token details using Rest API Fucntionality

  @API_Sanity
  Scenario: Successful Generation of Token with Valid email_ID and Password
    Given User send POST request for CreateToken using Base URI
    When User Enter the Body data as email id "abhinay.dixit@hotmail.com" and password "pass@1234"
    Then verify it successfully generated the response with status code "200"
    And verify token return from server