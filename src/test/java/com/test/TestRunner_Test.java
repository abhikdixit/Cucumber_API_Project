package com.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features = {"Feature"}
		features = {"Feature/Google_Search.feature"}
		,glue= "com.stepDefinition"
		//,dryRun=true
		,monochrome=true
		,plugin  = {"pretty","html:CucumberReport/Report"}
		//,tags={"@sanity,~@exclude"}
		)
public class TestRunner_Test {

}
