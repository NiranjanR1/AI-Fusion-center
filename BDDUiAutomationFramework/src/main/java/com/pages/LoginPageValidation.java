package com.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPageValidation {
	private WebDriver driver;
	private Actions action;
	HashMap<String,String> map = new HashMap<>(); 

	// By Locators:
	private By all_apps = By.xpath("//div[contains(@class, 'cursor-pointer')] ");

	public LoginPageValidation(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}	
	
	public void Login() throws InterruptedException {
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.ENTER).perform();
		String main = driver.getWindowHandle();
		Thread.sleep(5000);
		List<String> childs = new ArrayList<>(driver.getWindowHandles());
		System.out.println(childs);
		for(String child : childs) {
			System.out.println(child);
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
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.ENTER).perform();
		action.sendKeys(Keys.ENTER).perform();
		driver.switchTo().window(main);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		
	}

	public void getAllApps() {
		List<WebElement> apps = driver.findElements(all_apps);
		for (WebElement app : apps) {
			String app_text = app.getText();
			String b[] = app_text.split("\n");
			map.put(b[0], b[1]);
		}
		
		 for (Map.Entry<String, String> entry : map.entrySet()) {
	            System.out.println(entry.getKey() + " = " + entry.getValue());
	        }
		
		
	}
	
}
