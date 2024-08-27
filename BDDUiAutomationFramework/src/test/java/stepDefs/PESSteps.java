package stepDefs;

import java.io.IOException;

import com.pages.PESPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PESSteps {

	private PESPage pes = new PESPage(DriverFactory.getDriver());
	
	@When("open pes")
	public void open() throws InterruptedException {
		pes.open();
	}
	
	@Then("validate PES {string}")
	public void validate(String valid) throws InterruptedException {
		pes.validate(valid);
	}
	
	@Then("logout of pes")
	public void logout() throws InterruptedException {
		pes.logout();
	}
	
	@Then("validate the PES main page")
	public void PesMainPage() throws InterruptedException, IOException {
		pes.mainPage();
	}
	
}
