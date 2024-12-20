package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;
import pages.LoginPage;

public class TC_003_ProductSelectionTest extends ProjectSpecificationMethod {
	
	
		@BeforeTest
		public void setup() throws IOException {
		
		readFromPropFile("LoginTestData");
		testName = "ProductSelectionTest";
		testDescription = "Testing the searching the products functionality";
		testCategory = "Regression Testing";
		testAuthor = "Pradeep Kumar";
		
		}

		@Test
		public void productselectionTest() throws IOException {
		// TODO Auto-generated method stub

			readFromPropFile("LoginTestData");
			HomePage obj = new HomePage(driver);
			obj.loginClick()
			.username(prop.getProperty("validusername"))
			.password(prop.getProperty("validpassword"))
			.loginButton()
			.productselection()
			.validateProductSelection();
			
				
		}
		
	}


