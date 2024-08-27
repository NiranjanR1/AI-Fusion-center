package com.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class EchoDocsPage {

	private WebDriver driver;
	Actions action;
	JavascriptExecutor js;
	private Report report = Report.getInstance();
	
	private By open = By.xpath("//p[text()='Echo Docs']");
	private By url = By.xpath("//u[text() = 'Application URL']");
	private By checkBox = By.xpath("//input[@type= 'checkbox']");
	private By profile = By.xpath("//div[text()='NR']");
	private By validate = By.xpath("//h1");
	private By logout = By.xpath("//button[text()='Logout']");
	private By sso = By.xpath("//button[@type= 'submit']");
	
	public EchoDocsPage(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void open() throws InterruptedException, IOException {
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
	
	public void terms() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(checkBox).click();
		Thread.sleep(1000);
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER).perform();
	}
	
	public void logout() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(profile).click();
		Thread.sleep(1000);
		driver.findElement(logout).click();
		driver.close();
	}

	public void validate(String valid) throws InterruptedException {
		Thread.sleep(3000);
		if(valid.equals(driver.findElement(validate).getText()))
			System.out.println("Login to echo-docs successfull");
		else
			System.out.println("Login to echo-docs failed");
	}

	public void verifydashboard() throws IOException, InterruptedException {
		Thread.sleep(10000);
		if(driver.findElement(sso).isDisplayed())
			report.addReport(2, "Echo-docs","yes");
			
		else
			report.addReport(2,"Echo-docs","no");
		
	
	}
}
