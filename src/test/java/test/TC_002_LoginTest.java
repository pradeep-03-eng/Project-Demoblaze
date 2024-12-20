package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC_002_LoginTest extends ProjectSpecificationMethod{

	@BeforeTest
	public void setup() throws IOException {
		
		readFromPropFile("LoginTestData");
		testName = "LoginTest";
		testDescription = "Testing the login functionality with positive and negative test cases";
		testCategory = "Regression Testing";
		testAuthor = "Pradeep Kumar";
		
	}
	
	
	@Test
	public void logintest() {
		// TODO Auto-generated method stub
		
		HomePage obj = new HomePage(driver);
		obj.loginClick()
		.username(prop.getProperty("validusername"))
		.password(prop.getProperty("validpassword"))
		.loginButton()
		.validateLogin("validusernameandvalidpassword","Welcome pratheepk");
	}
	
	}


