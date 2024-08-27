package stepDefs;

import java.io.IOException;

import com.pages.KBSystemPages;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class KBSystemSteps {

	
	private KBSystemPages kb = new  KBSystemPages(DriverFactory.getDriver());
	
	@When("open KB System")
	public void open() throws InterruptedException {
		kb.open();
	}
	
	
	@Then("validate the KB system {string}")
	public void main(String id) throws IOException, InterruptedException {
		kb.validateMainPage(id);
	}
	
	@Then("provide the credentials {string} and {string}")
	public void login(String userId, String password) {
		kb.login(userId, password);
	}
	
	@And("clicks on submit")
	public void submit() {
		kb.submit();
	}
	
	@Then("logout from KB")
	public void logout() {
		kb.logout();
	}
}
