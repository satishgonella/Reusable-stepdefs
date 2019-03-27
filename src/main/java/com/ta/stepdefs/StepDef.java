package com.ta.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDef {

	private final WebDriver driver = new ChromeDriver();
	static{
		System.setProperty("webdriver.chrome.driver","/Users/satishgonella/Downloads/stepdefs-master/src/drivers/chromedriver");
	}


	@Given("something$")
	public void given() {
		System.out.println("Given");
	}

	@When("an event occurs")
	public void when() {
		System.out.println("When");
	}

	@Then("something else happens")
	public void then() {
		System.out.println("Then");
	}


	@Given("^I am on the Google search page$")
	public void I_visit_google() {

		driver.get("https:\\www.google.com");
	}

	@When("^I search for \"(.*)\"$")
	public void search_for(String query) {
		WebElement element = driver.findElement(By.name("q"));
		// Enter something to search for
		element.sendKeys(query);
		// Now submit the form. WebDriver will find the form for us from the element
		element.submit();
	}

	@Then("^the page title should start with \"(.*)\"$")
	public void checkTitle(final String titleStartsWith) {
		// Google's search is rendered dynamically with JavaScript
		// Wait for the page to load timeout after ten seconds
		new WebDriverWait(driver, 10L).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith(titleStartsWith);
			}
		});
	}

	@Given("^I am on the lloyds banking page$")
	public void I_visit_lloyds() {

		driver.get("https://www.lloydsbank.com");
	}

	@And("^I quit the browser$")
	public void I_quit_browser() {

		driver.quit();
	}

}
