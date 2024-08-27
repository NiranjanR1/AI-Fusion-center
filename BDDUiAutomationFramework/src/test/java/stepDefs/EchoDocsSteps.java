package stepDefs;

import java.io.IOException;

import com.pages.EchoDocsPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EchoDocsSteps {
	
	private EchoDocsPage echo = new EchoDocsPage(DriverFactory.getDriver());
	
    @When("Open echo-docs")
    public void open() throws InterruptedException, IOException {
    	echo.open();
    }
    
    @Then("accept terms & condition")
    public void login() throws InterruptedException {
    	echo.terms();
    }
    
    @Then("validate the echoDocs {string}")
    public void validate(String valid) throws InterruptedException {
    	echo.validate(valid);
    }
    
    @Then("Logout of echoDocs")
    public void logout() throws InterruptedException {
    	echo.logout();
    }
    
    @Then("validate the echo main page")
	public void main() throws InterruptedException, IOException {
		echo.verifydashboard();
	}
}
