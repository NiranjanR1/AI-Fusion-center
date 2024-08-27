package com.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TicketAnalzerPage {

	private WebDriver driver;
	Actions action;
	
	
	private Report report = Report.getInstance();
	private SendMail send = new SendMail();
	
	
	
	
	private By url = By.xpath("//u[text() = 'Application URL']");
	private By button = By.xpath("//button");
	private By open = By.xpath("//p[text()='Ticket Analyzer']");
	private By profile = By.xpath("//button[1]//child::div");
	private By logout = By.xpath("//li");
	private By userid = By.xpath("//input[@type='text']");
	private By pass = By.xpath("//input[@type='password']");
	private By checkbox = By.xpath("//input[@type='checkbox']");
	private By accept = By.xpath("//button[1]");
	private By submit = By.xpath("//button[@variant='contained']");
	private By valid = By.xpath("//img//parent::div[@class='pl-5']");
	
	public TicketAnalzerPage(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	public void open() throws InterruptedException {
		Thread.sleep(8000);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(open).click();
		Thread.sleep(8000);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		driver.findElement(url).click();
		Thread.sleep(7000);
	}


	public void logout() {
		driver.findElement(profile).click();
		driver.findElement(logout).click();
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.ENTER).perform();
	}


	public void login(String userId, String password) {
		driver.findElement(userid).sendKeys(userId);
		driver.findElement(pass).sendKeys(password);
	}
	
	public void accpetTerms() {
		driver.findElement(checkbox).click();
		driver.findElement(accept).click();
	}


	public void submit() {
		driver.findElement(submit).click();
	}


	public void validate() {
		if(driver.findElement(valid).isDisplayed())
			System.out.println("Login successfull for Ticket Analyzer");
		else
			System.out.println("Login failed for Ticket Analyzer");
	}


	public void mainPageValidation() throws InterruptedException, IOException {
		Thread.sleep(10000);
		if(driver.findElement(button).isDisplayed())
			report.addReport(8, "Ticket Analyzer", "Yes");
		else
			report.addReport(8, "Ticket Analyzer", "No");
		
		report.save();
		System.out.println("Sending email...");
		//send.sendMail();
		System.out.println("Email sent.");
	}
	
}
