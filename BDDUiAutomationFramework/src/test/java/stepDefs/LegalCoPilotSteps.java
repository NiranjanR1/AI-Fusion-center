package stepDefs;

import java.io.IOException;

import com.pages.LegalCoPilotPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LegalCoPilotSteps {

	private LegalCoPilotPage legal = new LegalCoPilotPage(DriverFactory.getDriver());
	
	@When("open legal")
	public void open() throws InterruptedException {
		legal.open();
	}
	
	@Then("logout of legal")
	public void logout() throws InterruptedException {
		legal.logout();
	}
	
	@Then("validate the legal main page")
	public void ValidateMainPage() throws IOException, InterruptedException {
		legal.mainPageValidation();
	}
	
	@Then("validate the legal co-pilot {string}")
	public void validate(String valid) throws InterruptedException {
		legal.validate(valid);
	}
}
