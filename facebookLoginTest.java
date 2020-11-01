package com.example.tests;//comment

import static org.junit.Assert.fail; //comment v2

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class plackiv2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {

	  Class<? extends WebDriver> driverClass = ChromeDriver.class;
	    WebDriverManager.getInstance(driverClass).setup();
	    driver = driverClass.newInstance();
	    		
	    baseUrl = "https://www.google.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

  
  }

  @Test
  public void testPlacki() throws Exception {
	  
		                    
		    
		        driver.get("https://www.google.com/");
		        Thread.sleep(2000);
		        driver.switchTo().frame(0);
		        driver.findElement(By.xpath("//*[@id=\"introAgreeButton\"]/span/span")).click();
		        driver.findElement(By.name("q")).clear();
		        driver.findElement(By.name("q")).sendKeys("sernik");
		        driver.findElement(By.id("tsf")).submit();
		     
		        driver.findElement(By.xpath("//div[@id='rso']/div[2]/div/div/a/h3/span")).click();
	  
   
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss(); 
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
