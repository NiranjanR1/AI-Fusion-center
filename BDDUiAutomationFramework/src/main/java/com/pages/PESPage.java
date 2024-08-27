package com.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class PESPage {

	
	private WebDriver driver;
	Actions action;
	
	
	private Report report = Report.getInstance();
	
	
	
	
	private By url = By.xpath("//u[text() = 'Application URL']");
	private By button = By.xpath("//button");
	private By open = By.xpath("//p[text()='Project Evaluation System']");
	private By validate = By.xpath("//button[1]//child::p");
	private By logout = By.xpath("//button[@aria-label='Logout']");
	
	public PESPage(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void open() throws InterruptedException {
		Thread.sleep(8000);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		driver.findElement(open).click();
		Thread.sleep(7000);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		driver.findElement(url).click();
		Thread.sleep(7000);
	}
	
	public void logout() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(logout).click();
		Thread.sleep(1000);
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER).perform();
		driver.close();
	}

	public void validate(String valid) throws InterruptedException {
		Thread.sleep(2000);
		if(driver.findElement(validate).getText().contains(valid))
			System.out.println("Login successfull to pes");
		else
			System.out.println("Login failed to pes");
	}

	public void mainPage() throws InterruptedException, IOException {
		Thread.sleep(10000);
		if(driver.findElement(button).isDisplayed())
			report.addReport(5, "PES", "Yes");
		else
			report.addReport(5, "PES", "No");
	}
	
}
