package stepDefs;

import com.pages.LoginPageValidation;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageValidationSteps {
	private LoginPageValidation userEnrollUpdatePage = new LoginPageValidation(DriverFactory.getDriver());
	
	@When("user login to application")
	public void LoginToAiFusionCenter() throws InterruptedException {
		userEnrollUpdatePage.Login();
	}

	@Then("get all the application")
	public void getAllApplication() {
		userEnrollUpdatePage.getAllApps();
	}
}