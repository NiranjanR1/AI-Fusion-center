package com.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class KBSystemPages {
	
	private WebDriver driver;
	Actions action;
	
	private Report report = Report.getInstance();
	
	
	private By url = By.xpath("//u[text() = 'Application URL']");
	private By open = By.xpath("//p[text()='KB System']");
	private By submit = By.xpath("//button[@type='submit']");
	private By profile = By.xpath("//div[contains(@class,'MuiToolbar-gutters')]//child::button[2]");
	private By logout = By.xpath("//a[@role='menuitem']");
	
	
	
	public KBSystemPages(WebDriver driver) {
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
		Thread.sleep(8000);
	}

	public void login(String userId, String password) {
		action.sendKeys(userId).perform();
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(password).perform();
	}

	public void submit() {
		driver.findElement(submit).click();
	}

	public void logout() {
		driver.findElement(profile).click();
		driver.findElement(logout).click();
	}

	public void validateMainPage(String id) throws IOException, InterruptedException {
		Thread.sleep(10000);
		if(id.equals("2000066666")) {
			if(driver.findElement(submit).isDisplayed())
				report.addReport(3, "KB System", "Yes");
			else
				report.addReport(3, "KB System", "No");
		}
		report.save();
	}
	
}
