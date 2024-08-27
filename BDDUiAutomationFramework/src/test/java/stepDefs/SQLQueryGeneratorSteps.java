package stepDefs;

import java.io.IOException;

import com.pages.SQLQueryGeneratorPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SQLQueryGeneratorSteps {

	private  SQLQueryGeneratorPage sql = new  SQLQueryGeneratorPage(DriverFactory.getDriver());
	
	@When("open SQl generator")
	public void open() throws InterruptedException {
		sql.open();
	}
	
	@Then("logout of sql generator")
	public void logout() throws InterruptedException {
		sql.logout();
	}
	
	@Then("validate SQL Query Generator {string}")
	public void validate(String valid) throws InterruptedException {
		sql.validate(valid);
	}
	
	@Then("validate the SQL Query Generator main page")
	public void SqlMainPage() throws IOException, InterruptedException {
		sql.mainPageValidation();
	}
}
