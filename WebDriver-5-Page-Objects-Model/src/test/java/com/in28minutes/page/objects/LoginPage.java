package com.in28minutes.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super();
		  driver.get("http://localhost:8080/login");
		  this.driver = driver ;
	}
	//name text box
	@FindBy(id="name")
	 WebElement name;
	
	@FindBy(id="password")
	//pasword text box
	 WebElement password;
	
	//submit btton
	@FindBy(id="submit")
	 WebElement submitButton;
	
	//enter name
	public void enterName(String nameToEnter){
	name.sendKeys(nameToEnter);
		
	}
	//enter password
	public void enterPassword(String passwordToEnter){
	 password.sendKeys(passwordToEnter);

		
	}
	//submit
	public void submit(){
		submitButton.submit();
	
	}
	public void login(String name, String password) {
		enterName(name);
		enterPassword(password);
		submit();
		
	
	}

}
