package com.stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition 

{
	static WebDriver driver = null;
	@Given("^User is on Google Home Page$")
	public void user_is_on_Google_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Entering to Method");
		WebDriverManager.chromedriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}

	@When("^User Enter the keyword \"([^\"]*)\"$")
	public void user_Enter_the_keyword(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("selenium");
	}

	@When("^User click on Search Button$")
	public void user_click_on_Search_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(6000);
		driver.findElement(By.name("btnK")).click();
	}

	@Then("^Search result related to \"([^\"]*)\" word should display$")
	public void search_result_related_to_word_should_display(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Search related to Selenium get Displayed");
	}
	@Given("User has Launched Browser in TestComplete")
	public void user_has_launched_browser_in_test_complete() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User Navigate to Sign On Page in TestComplete")
	public void user_navigate_to_sign_on_page_in_test_complete() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User enters username and password in TestComplete")
	public void user_enters_username_and_password_in_test_complete() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User Click on Login Button in TestComplete")
	public void user_click_on_login_button_in_test_complete() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User should logged in and WebOrders page should display in TestComplete")
	public void user_should_logged_in_and_web_orders_page_should_display_in_test_complete() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User LogOut from the Application")
	public void user_log_out_from_the_application() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Message displayed LogOut Successfully")
	public void message_displayed_log_out_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	
	// ------------------------Below is C Hook example----------
	@After
	public void CloseBrowser() {
		//driver.quit();
	}
}
