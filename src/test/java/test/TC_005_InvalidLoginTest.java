package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC_005_InvalidLoginTest extends ProjectSpecificationMethod {
	
	@BeforeTest
	public void setup() throws IOException {
		
		readFromPropFile("LoginTestData");
		testName = "InvalidLoginTest";
		testDescription = "Testing the invalidlogin functionality with positive and negative test cases";
		testCategory = "Regression Testing";
		testAuthor = "Pradeep Kumar";
		
	}

	
	@Test
	public void invalidlogintest() throws IOException {
		// TODO Auto-generated method stub
		
		readFromPropFile("LoginTestData");
		HomePage obj = new HomePage(driver);
		obj.loginClick()
		.username(prop.getProperty("invalidusername"))
		.password(prop.getProperty("validpassword"))
		.loginButton()
		.validateLogin("invalidusernameandvalidpassword","User does not exist.");
	}

	}


