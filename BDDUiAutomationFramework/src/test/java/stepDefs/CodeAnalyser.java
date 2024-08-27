package stepDefs;


import com.pages.CodeAnalyserPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CodeAnalyser {
	

	private CodeAnalyserPage code = new CodeAnalyserPage(DriverFactory.getDriver());

	@When("open code analyzer")
	public void Open() throws InterruptedException {
		code.open();
	}

	@Then("login to code Analyser")
	public void Login() {
		code.login();
	}
}
