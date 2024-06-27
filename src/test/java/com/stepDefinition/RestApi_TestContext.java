package com.stepDefinition;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestApi_TestContext {

	protected Response response;
	protected RequestSpecification httpRequest;
	protected JsonPath jsonPathEvaluator;
}
