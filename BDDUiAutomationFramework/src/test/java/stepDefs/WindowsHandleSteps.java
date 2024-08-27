package stepDefs;

import com.pages.WindowsHandlePage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WindowsHandleSteps {

	
	private WindowsHandlePage windows = new WindowsHandlePage(DriverFactory.getDriver());

	@Given("Switch to child windows")
	public void switchWindowChild() {
		windows.childWindow();
	}
	
	
	
	@Given("Switch to main windows")
	public void switchWindowMain() {
		windows.mainWindow();
	}
	


}
