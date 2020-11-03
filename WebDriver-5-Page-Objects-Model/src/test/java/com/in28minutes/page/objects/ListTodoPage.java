package com.in28minutes.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListTodoPage {
	private WebDriver driver;
	
	public ListTodoPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public String getDescription(String id) {
		return driver.findElement(By.id("desc-" + id)).getText();
	}
	public String getTargetDate(String id) {
		return driver.findElement(By.id("targetdate-" + id)).getText();
}
	public void clickUpdateFor(String id) {
		driver.findElement(By.id("update-" + id)).click();
}
	public void deleteId(String id) {
		driver.findElement(By.id("desc-" + id)).clear();
		driver.findElement(By.id("targetDate-" + id)).clear();
}
}