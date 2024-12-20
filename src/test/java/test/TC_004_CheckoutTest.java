package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC_004_CheckoutTest extends ProjectSpecificationMethod {
	
	@BeforeTest
	public void setup() throws IOException {
		
		readFromPropFile("LoginTestData");
		testName = "CheckoutTest";
		testDescription = "Testing the order checkout functionality";
		testCategory = "Regression Testing";
		testAuthor = "Pradeep Kumar";
		
	}

	@Test
	public void CheckoutTest () throws IOException {
		// TODO Auto-generated method stub
		
		readFromPropFile("LoginTestData");
		HomePage obj = new HomePage(driver);
		obj.loginClick()
		.username(prop.getProperty("validusername"))
		.password(prop.getProperty("validpassword"))
		.loginButton()
		.checkoutPage()
		.validatecheckout();
	}

}
