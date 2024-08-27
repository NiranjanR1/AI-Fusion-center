package com.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.factory.DriverFactory;

public class ClinicalPage {

	private WebDriver driver;
	Actions action;
	WebDriverWait wait;
	
	private Report report = Report.getInstance();

	private By url = By.xpath("//u[text() = 'Application URL']");
	private By profile = By.xpath("//*[local-name()='svg'][1]//parent::div");
	private By docManagement = By.xpath("//*[contains(@class, 'absolute')]//child::div[2]");
	private By button = By.xpath("//table[@style='table-layout: auto;']//child::tr[1]//child::button");
	private By SSO = By.xpath("//button[contains(text(),'SSO')]");
	private By delete = By.xpath("//ul[contains(@class, 'drop')]//child::li[2]");
	private By edit = By.xpath("//ul[contains(@class, 'drop')]//child::li[1]");
	private By inputBox = By.xpath("//table[@style='table-layout: auto;']//child::tr[1]//child::td[1]//child::input");
	private By save = By.xpath("//*[text()='Save']");
	private By cancel = By.xpath("//*[text()='Cancel']");
	private By docDownload = By.xpath("//ul[contains(@class, 'drop')]//child::li[3]");
	private By inputDrug = By.xpath("//*[@placeholder='Type Disease & Medicine Name']");
	private By generate = By.xpath("//button");
	private By anotherResponse = By.xpath("//div[contains(@class,'gap')]//child::button[2]");
	private By download = By.xpath("//div[contains(@class,'start')]//child::button[1]");
	private By logout = By.xpath("//*[contains(@class, 'absolute')]//child::div[4]"); 
	private By confirmCancel = By.xpath("//div[@class='ant-modal-footer']//child::button[1]");
	private By confirmLogout = By.xpath("//div[@class='ant-modal-footer']//child::button[2]");
	private By dashboard = By.xpath("//p[text()='Dashboard']");
	private By validate = By.xpath("//p[text()='UNLOCKING INSIGHTS']");
	
	public ClinicalPage(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}	
	
	
	
	public void dashboard() throws InterruptedException {
		DriverFactory.getDriver().get("https://genai-solutions.tensai.run/");
		Thread.sleep(4000);
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.ENTER).perform();
		String main = driver.getWindowHandle();
		Thread.sleep(5000);
		List<String> childs = new ArrayList<>(driver.getWindowHandles());
		for(String child : childs) {
			if(!(child.equals(main))) {
				driver.switchTo().window(child);
				break;
			}
		}
		action.sendKeys("2000112411@hexaware.com").perform();
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(6000);
		action.sendKeys("Gopi@oct2001").perform();
		Thread.sleep(3000);
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		action.sendKeys(Keys.ENTER).perform();
		driver.switchTo().window(main);
	}
	
	public void open() throws InterruptedException, IOException {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[text()='Clinical Co-Pilot']")).click();
		Thread.sleep(8000);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		driver.findElement(url).click();
		Thread.sleep(7000);
		
	}
	
	public void Login() {
		//driver.findElement(SSO).click();
		System.out.println("started login");
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.ENTER).perform();
	}
	
	
	
	
	public void delete() throws InterruptedException {
		driver.findElement(profile).click();
		Thread.sleep(1000);
		driver.findElement(docManagement).click();
		driver.findElement(button).click();
		Thread.sleep(1000);
		Thread.sleep(2000);
		driver.findElement(delete).click();
	}
	
	public void edit() throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(button).click();
		Thread.sleep(1000);
		driver.findElement(edit).click();
	    System.out.println(driver.findElement(inputBox).getText());
		driver.findElement(inputBox).click();
		action.keyDown(Keys.CONTROL).sendKeys("a").perform();
		action.keyUp(Keys.CONTROL).perform();
		action.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(4000);
		driver.findElement(inputBox).sendKeys("Edited file");
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(save)).click().perform();
		
	}
	
	public void cancel() throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(button).click();
		Thread.sleep(1000);
		driver.findElement(edit).click();
	    System.out.println(driver.findElement(inputBox).getText());
		driver.findElement(inputBox).click();
		action.keyDown(Keys.CONTROL).sendKeys("a").perform();
		action.keyUp(Keys.CONTROL).perform();
		action.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(4000);
		driver.findElement(inputBox).sendKeys("Edited file");
		Thread.sleep(3000);
		driver.findElement(cancel).click();
		Thread.sleep(5000);
	}
	
	public void docManagemntDownload() throws InterruptedException {
		driver.findElement(button).click();
		Thread.sleep(2000);
		driver.findElement(docDownload).click();
		Thread.sleep(4000);
		driver.navigate().back();
	}
	
	public void generateReport(String drug) throws InterruptedException {
		Thread.sleep(5000);
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.BACK_SPACE).perform();
		action.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.ENTER).perform();
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.BACK_SPACE).perform();
		action.sendKeys(Keys.BACK_SPACE).perform();
		action.sendKeys(Keys.ENTER).perform();
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		driver.findElement(inputDrug).sendKeys(drug);;
		driver.findElement(generate).click();
	}
	
	public void download() throws InterruptedException { 
		wait = new WebDriverWait(driver,1500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(anotherResponse));
		driver.findElement(download).click();
		Thread.sleep(3000);
	}
	
	public void confirmCancelLogout() throws InterruptedException {
		driver.findElement(profile).click();
		Thread.sleep(1000);
		driver.findElement(logout).click();
		Thread.sleep(2000);
		driver.findElement(confirmCancel).click();
		Thread.sleep(2000);
	}
	
	public void logout() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(profile).click();
		Thread.sleep(1000);
		driver.findElement(logout).click();
		Thread.sleep(2000);
		driver.findElement(confirmLogout).click();
		driver.close();
	}
	
	public void dashboardPage() throws InterruptedException {
		Thread.sleep(4000);
		action.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(2000);
		driver.findElement(dashboard).click();
	}

	public void validatepage(String valid) {
		if(valid.equals(driver.findElement(validate).getText()))
			System.out.println("Login successfull");
		else
			System.out.println("Login failed");
	}



	public void verifydashboard() throws IOException {
		if(driver.findElement(SSO).isDisplayed()) {
			report.addReport(1,"Clinical Co-Pilot","yes");
		}
		else
			report.addReport(1,"Clinical Co-Pilot","no");
	}
	
}

