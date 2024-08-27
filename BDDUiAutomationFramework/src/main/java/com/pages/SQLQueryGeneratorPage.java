package com.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SQLQueryGeneratorPage {

	private WebDriver driver;
	Actions action;
	
	
	private Report report = Report.getInstance();
	
	
	private By url = By.xpath("//u[text() = 'Application URL']");
	private By button = By.xpath("//button");
	private By open = By.xpath("//p[text()='SQL Query Generator']");
	private By profile = By.xpath("//div[text()='NR']");
	private By validate = By.xpath("//div[contains(@style,'end')][1]//child::p");
	private By logout = By.xpath("//ul[1]");
	
	
	
	public SQLQueryGeneratorPage(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	public void open() throws InterruptedException {
		Thread.sleep(8000);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		driver.findElement(open).click();
		Thread.sleep(8000);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		driver.findElement(url).click();
		Thread.sleep(7000);
	}
	
	public void logout() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(profile).click();
		Thread.sleep(1000);
		driver.findElement(logout).click();
		driver.close();
	}


	public void validate(String valid) throws InterruptedException {
		Thread.sleep(2000);
		if(valid.equals(driver.findElement(validate).getText()))
			System.out.println("Login successfull for SQL Query Generator");
		else
			System.out.println("Login failed for SQL Query Generator");
	}


	public void mainPageValidation() throws IOException, InterruptedException {
		Thread.sleep(10000);
		if(driver.findElement(button).isDisplayed())
			report.addReport(6, "SQL Query Generator", "Yes");
		else
			report.addReport(6, "SQL Query Generator ", "No");
	}
}
