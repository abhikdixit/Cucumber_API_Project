package com.test;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		//features = {"Feature/ToGet_Book_Details_Using_ISBN_Number.feature"}
		//features = {"Feature/Login_In_As_Existing_User.feature"}
		features = {"Feature/Create_Notes_Using_Token.feature"}
		//features = {"Feature_API/NopCommerce_Login.feature","Feature/OrangeHRM_Login.feature"}
		//features = {"Feature"}
		//This is to execute only failed scenarios
		//features = {"@FailedTests/failed_TCs.txt"}
		,glue= "com.stepDefinition"
		,dryRun=false
		,monochrome=true
		,plugin  = {"pretty","html:CucumberReport/MyNotes_API.html"}
		//,plugin  = {"pretty","html:CucumberReport/MasterReport.html","rerun:FailedTests/failed_TCs.txt"}
		//,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} 
		//Execute all of them Except Sanity
		//,tags="not @smoke"
		// Execute Smoke and Sanity both test cases
		//,tags= "@smoke or @sanity"
		// Execute Smoke and Sanity , but both should be marked together in feature
		//,tags= "@smoke and @sanity"
		//,tags= "@smoke"
		//,tags= "@E2E"
		
		)
public class TestRunner_MyNotes {

}
