package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class LoginPage extends ProjectSpecificationMethod {
	
	@FindBy(id="loginusername")
	WebElement userName;
	
	@FindBy(id="loginpassword")
	WebElement pass;
	
	@FindBy(xpath="//button[contains(text(), 'Log in')]")
	WebElement login;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public  LoginPage username(String username) {
		
		SendKeysMethod(userName,username);
		return this;
		
	}

	public  LoginPage password(String password) {
		
		SendKeysMethod(pass,password);
		return this;
}

	public  HomePage loginButton() {
		
		login.click();
		return new HomePage(driver);
	
}
	
}
