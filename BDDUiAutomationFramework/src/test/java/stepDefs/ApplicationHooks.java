package stepDefs;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);	
	}
	
//	@Before(order = 2)
//	public void login() throws InterruptedException {
//		DriverFactory.getDriver().get("https://genai-solutions.tensai.run/");
//		action.sendKeys(Keys.TAB).perform();
//		action.sendKeys(Keys.ENTER).perform();
//		String main = driver.getWindowHandle();
//		Thread.sleep(5000);
//		List<String> childs = new ArrayList<>(driver.getWindowHandles());
//		for(String child : childs) {
//			System.out.println(child);
//			if(!(child.equals(main))) {
//				driver.switchTo().window(child);
//				break;
//			}
//		}
//		action.sendKeys("2000112411@hexaware.com").perform();
//		action.sendKeys(Keys.TAB).perform();
//		action.sendKeys(Keys.TAB).perform();
//		action.sendKeys(Keys.ENTER).perform();
//		Thread.sleep(6000);
//		action.sendKeys("Gopi@oct2001").perform();
//		action.sendKeys(Keys.TAB).perform();
//		action.sendKeys(Keys.ENTER).perform();
//		action.sendKeys(Keys.ENTER).perform();
//		driver.switchTo().window(main);
//	}

	@After(order = 0)
	public void quitBrowser() {
		//driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}

}
