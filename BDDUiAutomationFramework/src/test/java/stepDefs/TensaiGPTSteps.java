package stepDefs;

import java.io.IOException;

import com.pages.TensaiGPTPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TensaiGPTSteps {

	private TensaiGPTPage gpt = new  TensaiGPTPage(DriverFactory.getDriver());
	
	@When("open TensaiGPT")
	public void open() throws InterruptedException {
		gpt.open();
	}
	
	@Then("logout of TensaiGPT")
	public void logout() throws InterruptedException {
		gpt.logout();
	}
	
	@Then("validate TensaiGPT")
	public void validate() throws InterruptedException {
		gpt.validate();
	}
	
	@Then("validate the TensaiGPT main page")
	public void TensaiMainPage() throws IOException, InterruptedException {
		gpt.MainPageValidation();
	}
}
