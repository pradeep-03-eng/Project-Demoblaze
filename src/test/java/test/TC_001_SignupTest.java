package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC_001_SignupTest extends ProjectSpecificationMethod {
	
	@BeforeTest
	public void setup() throws IOException {
	
	readFromPropFile("SignupTestData");
	testName = "SignupTest";
	testDescription = "Testing the Signup functionality with positive and negative test cases";
	testCategory = "Regression Testing";
	testAuthor = "Pradeep Kumar";
	
	}

	
	@Test
	public void signup() throws InterruptedException {
		// TODO Auto-generated method stub

		HomePage obj = new HomePage(driver);
		obj.signupClick()
		.username("pks")
		.password("123456")
		.signupButton()
		.validateSignup();
	}

}
