package com.in28minutes.webDriver.scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import com.in28minutes.webDriver.basics.AbstractChromeWebDriverTest;
import com.in28minutes.webDriver.scenarios.framework.TableReader;

public class ReadTablesTest extends AbstractChromeWebDriverTest {
	@Test
  	public void testReadingOfTables() throws IOException {
		
	driver.get("http://localhost:8080/pages/tables.html");
	
	TableReader reader = new TableReader(driver, "dataTables-example " );
	System.out.println(reader.getData(1,2));
	System.out.println(reader.getData(2,2));
	System.out.println(reader.getData(5,4));
	System.out.println(reader.getData(6,3));
	
	TableReader reader2 = new TableReader(driver, "dataTables-example-2 ");
	System.out.println(reader2.getData(2, 2));


	
	
	}
	
}