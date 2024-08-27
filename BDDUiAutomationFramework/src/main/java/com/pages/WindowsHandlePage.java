package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class WindowsHandlePage {

	private WebDriver driver;
	private String main;

	// Constructor of the page class
	public WindowsHandlePage(WebDriver driver) {
		this.driver = driver;
	}

	public void childWindow() {
		main = driver.getWindowHandle();
		List<String> childs = new ArrayList<>(driver.getWindowHandles());
		for(String child : childs) {
			if(!(child.equals(main))) {
				driver.switchTo().window(child);
			    break;
			}
		}
	}

	public void mainWindow() {
		driver.switchTo().window(main);
	}
	
	

}
