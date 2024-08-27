package com.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TensaiGPTPage {

	private WebDriver driver;
	Actions action;
	
	
	private Report report = Report.getInstance();
	
	
	private By url = By.xpath("//u[text() = 'Application URL']");
	private By button = By.xpath("//button");
	private By open = By.xpath("//p[text()='TensaiGPT']");
	private By profile = By.xpath("//span[text()='NR']");
	private By input = By.xpath("//textarea");
	private By logout = By.xpath("//li[@role='menuitem'][2]");
	

	public TensaiGPTPage(WebDriver driver) {
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
	
	public void logout() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(profile).click();
		Thread.sleep(1000);
		driver.findElement(logout).click();
		driver.close();
	}


	public void validate() throws InterruptedException {
		Thread.sleep(2000);
		if(driver.findElement(input).isDisplayed())
			System.out.println("Login successfull for tensaiGPT");
		else
			System.out.println("Login failed for tensaiGPT");
	}


	public void MainPageValidation() throws IOException, InterruptedException {
		Thread.sleep(10000);
		if(driver.findElement(button).isDisplayed())
			report.addReport(7, "TensaiGPT", "Yes");
		else
			report.addReport(7, "TensaiGPT", "No");
		
	}
}
