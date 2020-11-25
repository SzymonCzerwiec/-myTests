package com.in28minutes.page.objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateToDoBasicTestNewTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	}
	
	  @Test
	  public void loginPageObjet() {

		  driver.get("http://localhost:8080/login");
		  
		  LoginPage page = PageFactory.initElements(driver, LoginPage.class);
		 // driver.findElement(By.id("name")).getAttribute("type"));
		  System.out.println(page.name.getAttribute("type"));
		  // // driver.findElement(By.id("password")).getAttribute("type"));
		  System.out.println(page.password.getAttribute("type"));

		   }
  @Test
  public void updateToDo() {

	  
	  LoginPage page = PageFactory.initElements(driver, LoginPage.class);
	  page.login("in28minutes", "dummy");
	  
	  sleep(3);
	  driver.findElement(By.linkText("Click here")).click();
	  sleep(3);
	  
	  ListTodoPage listTodoPage = new  ListTodoPage(driver);
	  listTodoPage.clickUpdateFor("10002");
	  sleep(3);
	  
	  ToDoPage todoPage = PageFactory.initElements(driver, ToDoPage.class);
	  todoPage.enterDetails("Tech guru -2 ", "28/05/2050");

	  assertEquals(listTodoPage.getDescription("10002"),"Tech guru -2");
	  assertEquals(listTodoPage.getTargetDate("10002"),"28/05/2050");

	}

@AfterTest
  public void afterTest() {
	  driver.quit();
  
}
	private void sleep(int i) {
try {
	Thread.sleep(i*1000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
		}
	}
	
}
