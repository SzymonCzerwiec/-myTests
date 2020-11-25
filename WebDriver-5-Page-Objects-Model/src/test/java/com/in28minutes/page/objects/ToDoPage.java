package com.in28minutes.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToDoPage {
	
	
	private WebDriver driver;
	
	public ToDoPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	@FindBy(id="desc")
	private WebElement description;
	
	@FindBy(id = "targetDate")
	private WebElement target;
	
	@FindBy(id= "save")
	private WebElement saveButton;
	
	public void enterDescription (String desc){
		description.clear();
		description.sendKeys(desc);
		
	}
	public void enterTargetDate(String date) {
		target.clear();
		target.sendKeys(date);
		
	}
	public void submit () {
		saveButton.submit();
	}
	public void enterDetails (String description, String date) {
		enterDescription(description);
		enterTargetDate(date);
		submit();
	}
}
