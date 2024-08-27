package stepDefs;

import java.io.IOException;

import com.pages.ClinicalPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Clinical {
	
	private ClinicalPage clinic = new ClinicalPage(DriverFactory.getDriver());
	
	@Given("user is on dashboard page")
	public void dashboard() throws InterruptedException {
		clinic.dashboard();
	}

	@When("Open clinical Co-pilot")
	public void Login() throws InterruptedException, IOException {
		clinic.open();
	}
	
	@Then("validate the main page")
	public void main() throws InterruptedException, IOException {
		clinic.verifydashboard();
	}
	
	@Then("login")
	public void login() {
		clinic.Login();
	}
	
	@Then("validate the clinical page {string}")
	public void validate(String valid) {
		clinic.validatepage(valid);
	}
	
	@Then("delete the document")
	public void delete() throws InterruptedException {
		clinic.delete();
	}
	
	@Then("edit the document")
	public void edit() throws InterruptedException {
		clinic.edit();
	}
	
	@Then("Edit the document and then click cancel")
	public void cancelEditedName() throws InterruptedException {
		clinic.cancel();
	}
	
	@Then("download the document in doc management")
	public void Docdownload() throws InterruptedException {
		clinic.docManagemntDownload();
	}
	
	@Then("generate the document for {string}")
	public void generateReport(String drug) throws InterruptedException {
		clinic.generateReport(drug);
	}
	
	@Then("click on download")
	public void download() throws InterruptedException {
		clinic.download();
	}
	
	@Then("click on cancel logout")
	public void cancel() throws InterruptedException {
		clinic.confirmCancelLogout();
	}
	
	@Then("click on confirm logout")
	public void logout() throws InterruptedException {
		clinic.logout();
	}
	
	@Then("move to dashboard page")
	public void dashboardPage() throws InterruptedException {
		clinic.dashboardPage();
	}
}
