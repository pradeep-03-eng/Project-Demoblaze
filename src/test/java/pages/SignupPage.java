package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class SignupPage extends ProjectSpecificationMethod {
	
	
	@FindBy(id="sign-username")
	WebElement signusername;
	
	@FindBy(id="sign-password")
	WebElement signpassword;
	
	@FindBy(xpath="//button[contains(text(), 'Sign up')]")
	WebElement signup;
	
	public SignupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		this.driver = driver;
		
	}
	
	
	public SignupPage username(String username) throws InterruptedException {
		
		Thread.sleep(2000);
		
		SendKeysMethod(signusername,username);
		return this;
		
	}

	public SignupPage password(String password) {
		
		SendKeysMethod(signpassword, password);
		return this;
		
	}
	
	public RegisterResult signupButton() {
		
		signup.click();
		return new RegisterResult(driver);
		
	}
}
