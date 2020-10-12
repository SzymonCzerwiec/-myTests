package com.in28minutes.test.testng;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstSeleniumTestNGTest {
	
	WebDriver webDriver;
	
	@BeforeTest
	public void before() {
		//set the path to web driver executable
				WebDriverManager.chromedriver().setup();
				
				//create an instance of WebDriver
				 webDriver = new ChromeDriver();
		
	}

	@Test
	public void testGoogleDotCom() {
		
		
		
		//webDriver- Lanuch up to http://www.google.com
		webDriver.get("http://www.google.com");
		
		//https://www.google.com/?gws_rd=ssl
		String actualResult = webDriver.getTitle();
		String expectedResult = "Google";
		assertEquals (expectedResult ,actualResult) ;
	
	//check output, WebDriver -Title is Google
		

}
	@Test
	public void testFacebookDotCom() {
		
		webDriver.get("http://www.Facebook.com");
		String actualResult = webDriver.getTitle();
		String expectedResult = "Facebook – zaloguj się lub zarejestruj" ;
		assertEquals  (expectedResult,actualResult);
		
				}
	@Test
	@Ignore
		public void testDummy () {
		webDriver.get("dummy");
		String actualResult = webDriver.getTitle();
		String expectedResult = "dummyfuck";
		assertEquals (actualResult,expectedResult);
	}
	@AfterTest
	
	public void after() {
		webDriver.quit();
	}
	}
