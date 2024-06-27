package com.stepDefinition;

import org.json.simple.JSONObject;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class RestAssured_MyNotes {
	String token_value;
	private RestApi_TestContext stepData;

	// Now with just adding Constructor to RestAssuredAPIStepDefinition file and
	// pass
	// RestApi_TestContext as a Parameter to constructor would take all the pain.
	// Within the RestApi_TestContext object we have everything available which is
	// required for the test
	public RestAssured_MyNotes(RestApi_TestContext stepData) {
		this.stepData = stepData;
	}

	@Given("User is on RestBookStore URI Home Page")
	public void user_is_on_rest_book_store_uri_home_page() {
		// Write code here that turns the phrase above into concrete actions
		// Write code here that turns the phrase above into concrete actions
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://bookstore.toolsqa.com";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		stepData.httpRequest = RestAssured.given();
	}

	@When("User Enter the valid ISBN Number {string}")
	public void user_enter_the_valid_isbn_number(String isbn) {
		// Write code here that turns the phrase above into concrete actions
		// RestAssured httpRequest = null;
		// Write code here that turns the phrase above into concrete actions
		// Make a request to the server by specifying the method Type and the method
		// URL.
		// This will return the Response from the server. Store the response in a
		// variable.
		stepData.response = stepData.httpRequest.request(Method.GET, "/BookStore/v1/Book?ISBN=" + isbn);
	}

	@Then("verify Status code should be {string}")
	public void verify_status_code_should_be(String Expcode) {
		// Write code here that turns the phrase above into concrete actions
		int statusCode = stepData.response.getStatusCode();
		int Exp_Statuscode_AsINT = Integer.parseInt(Expcode);
		System.out.println("Status code is =>  " + statusCode);
		Assert.assertEquals(Exp_Statuscode_AsINT, statusCode);
	}

	@Then("verify Title of the books return from server")
	public void verify_title_of_the_books_return_from_server() {
		// Write code here that turns the phrase above into concrete actions
		String responseBody = stepData.response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		stepData.jsonPathEvaluator = new JsonPath(responseBody);
		String title_act = stepData.jsonPathEvaluator.get("title");
		System.out.println(title_act);
		Assert.assertEquals(title_act, "Git Pocket Guide");
	}

	@Given("User send POST request for CreateToken using Base URI")
	public void user_send_post_request_for_create_token_using_base_uri() {
		// Write code here that turns the phrase above into concrete actions
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://practice.expandtesting.com";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		stepData.httpRequest = RestAssured.given();
	}

	@When("User Enter the Body data as email id {string} and password {string}")
	public void user_enter_the_body_data_as_email_id_and_password(String email, String password) {
		// Write code here that turns the phrase above into concrete actions
		JSONObject requestParams = new JSONObject();
		requestParams.put("email", email);
		requestParams.put("password", password);
		// Add a header stating the Request body is a JSON
		stepData.httpRequest.header("Content-Type", "application/json");
		stepData.httpRequest.body(requestParams.toJSONString());
		// POST the Response
		stepData.response = stepData.httpRequest.request(Method.POST, "/notes/api/users/login");
	}

	@Then("verify it successfully generated the response with status code {string}")
	public void verify_it_successfully_generated_the_response_with_status_code(String Expcode) {
		// Write code here that turns the phrase above into concrete actions
		int statusCode = stepData.response.getStatusCode();
		int Exp_Statuscode_AsINT = Integer.parseInt(Expcode);
		System.out.println("Status code is =>  " + statusCode);
		Assert.assertEquals(Exp_Statuscode_AsINT, statusCode);
	}

	@Then("verify token return from server")
	public void verify_token_return_from_server() {
		// Write code here that turns the phrase above into concrete actions
		String responseBody = stepData.response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		stepData.jsonPathEvaluator = new JsonPath(responseBody);
		token_value = stepData.jsonPathEvaluator.get("data.token");
		System.out.println("Token code is =>  " + token_value);
	}

	@Given("User send POST request for Create Notes")
	public void user_send_post_request_for_create_notes() {
		// Write code here that turns the phrase above into concrete actions
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://practice.expandtesting.com";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		stepData.httpRequest = RestAssured.given();
	}

	@When("User Enter Notes details data like {string},{string},{string} through Body")
	public void user_enter_notes_details_data_like_through_body(String title, String desc, String category) {
		// Write code here that turns the phrase above into concrete actions
		JSONObject newNotes = new JSONObject();
		newNotes.put("title", title);
		newNotes.put("description", desc);
		newNotes.put("category", category);
		// Add a header stating the Request body is a JSON
		stepData.httpRequest.header("Content-Type", "application/json");
		stepData.httpRequest.header("x-auth-token", "" +token_value);
		stepData.httpRequest.body(newNotes.toJSONString());
		// Write code here that turns the phrase above into concrete actions
		stepData.response = stepData.httpRequest.request(Method.POST, "/notes/api/notes");

	}

	@Then("verify that, it successfully generated the response with status code {string}")
	public void verify_that_it_successfully_generated_the_response_with_status_code(String Expcode) {
		// Write code here that turns the phrase above into concrete actions
		// Write code here that turns the phrase above into concrete actions
				int statusCode = stepData.response.getStatusCode();
				int Exp_Statuscode_AsINT = Integer.parseInt(Expcode);
				System.out.println("Status code is =>  " + statusCode);
				Assert.assertEquals(Exp_Statuscode_AsINT, statusCode);
	}

	@Then("verify the Title of the Notes, which returned by server")
	public void verify_the_title_of_the_notes_which_returned_by_server() {
		// Write code here that turns the phrase above into concrete actions
		String responseBody = stepData.response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		stepData.jsonPathEvaluator = new JsonPath(responseBody);
		String Act_Title = stepData.jsonPathEvaluator.get("data.title");
		System.out.println("Title Name is =>  " + Act_Title);
		Assert.assertEquals(Act_Title, "RestAssured_Cucumber");
	}
}
