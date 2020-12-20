package com.in28minutes.webDriver.scenarios; 

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.in28minutes.webDriver.basics.AbstractChromeWebDriverTest;

public class testForNewWindow extends AbstractChromeWebDriverTest {
	@Test
  	public void testForWindow() {
	driver.get("http://localhost:8080/pages/notifications.html");
	System.out.println("0 -" + driver.getWindowHandle());
	//0 -0 -CDwindow-9FFBACB7EF4C91748BB8A6CF51837624

	
	driver.findElement(By.id("newPageButton")).click();
		
	//window Handle
	//1 -1 -CDwindow-B13913124DB9211455D3B3682451174E
	System.out.println("1 -" + driver.getWindowHandle());
	
	//2 -2 -[CDwindow-B13913124DB9211455D3B3682451174E, CDwindow-20B65758DC292C5650E165DF32A7B7A0]
	System.out.println("2 -" + driver.getWindowHandles());

	
	for(String handle:driver.getWindowHandles()) {
		
		}
	}

  
	@Test
  	public void findWindowHandleOfSecondWindow() { //bartrk tlyumnacz
	driver.get("http://localhost:8080/pages/notifications.html");
	
	String firstWindowHandle = driver.getWindowHandle();

	
	driver.findElement(By.id("newPageButton")).click();
		
	String secondWindowHandle = findSecondHandle(firstWindowHandle);
	System.out.println(secondWindowHandle);
	System.out.println(firstWindowHandle);

	}


	private String findSecondHandle(String firstWindowHandle) {
		
		for(String handle:driver.getWindowHandles()) {
			if(!firstWindowHandle.equals(handle)) {
				return  handle;
			}
		}
		return null;

	}
	

	@Test
  	public void switchToSecondWindow() {//bartrk tlyumnacz
		
	driver.get("http://localhost:8080/pages/notifications.html");
	
	String firstWindowHandle = driver.getWindowHandle();
	System.out.println(firstWindowHandle);

	
	driver.findElement(By.id("newPageButton")).click();		
	
	String secondWindowHandle = findSecondHandle(firstWindowHandle);//dlaczego najpeirw prnt pierwsza strone jak ciagle 
	//jest w drugiej stronie
	
	System.out.println(secondWindowHandle);

	
	System.out.println(driver.findElement(By.tagName("h1")).getText());//Notifications

	driver.switchTo().window(secondWindowHandle);
	
	System.out.println(driver.findElement(By.tagName("h1")).getText());//Forms
	
	driver.switchTo().window(firstWindowHandle);
	System.out.println(driver.findElement(By.tagName("h1")).getText());//Notifications
	System.out.println(driver.getCurrentUrl());

	driver.close();
	driver.switchTo().window(secondWindowHandle);
	System.out.println(driver.getCurrentUrl());//forms
//just making some changes dont mind me
	
}
}
