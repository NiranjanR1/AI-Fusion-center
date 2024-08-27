package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CodeAnalyserPage {
	private WebDriver driver;
	Actions action;

	private By url = By.xpath("//u[text() = 'Application URL']");
	
	public CodeAnalyserPage(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}	
	
	public void open() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[text()='Code Analyzer']")).click();
		Thread.sleep(5000);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		driver.findElement(url).click();
		Thread.sleep(7000);
	}
	
	public void login() {
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.ENTER).perform();
	}
}
