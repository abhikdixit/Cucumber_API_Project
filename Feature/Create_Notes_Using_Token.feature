#Author: Abhinay Dixit
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
@API_Smoke
Feature: To Test Create Notes functionality

  Background: Successful Generation of Token with Valid email_ID and Password
    Given User send POST request for CreateToken using Base URI
    When User Enter the Body data as email id "abhinay.dixit@hotmail.com" and password "pass@1234"
    Then verify it successfully generated the response with status code "200"
    And verify token return from server

  Scenario: Successful creation of Notes with Valid details
    Given User send POST request for Create Notes
    When User Enter Notes details data like "RestAssured_Cucumber","Created Notes through RestAssured API Code","Work" through Body
    Then verify that, it successfully generated the response with status code "200"
    And verify the Title of the Notes, which returned by server