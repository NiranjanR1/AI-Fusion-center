package stepDefs;

import java.io.IOException;

import com.pages.TicketAnalzerPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TicketAnalzerStep {

	
	private TicketAnalzerPage ticket = new  TicketAnalzerPage(DriverFactory.getDriver());
	
	@When("open Ticket Analyzer")
	public void open() throws InterruptedException {
		ticket.open();
	}
	
	@Then("validate on Ticket Analyzer")
	public void validate() {
		ticket.validate();
	}
	
	@Then("logout of Ticket Analyzer")
	public void logout() {
		ticket.logout();
	}
	
	@And("login with cred {string} and {string}")
	public void login(String userId, String password) {
		ticket.login(userId, password);
		ticket.accpetTerms();
	}
	
	@And("click on submit")
	public void submit() {
		ticket.submit();
	}
	
	@Then("validate the Ticket Analyser main page")
	public void TicketAnalyserMainPage() throws InterruptedException, IOException {
		ticket.mainPageValidation();
	}
}
