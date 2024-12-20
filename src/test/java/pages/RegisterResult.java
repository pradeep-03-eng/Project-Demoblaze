package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import base.ProjectSpecificationMethod;
import io.opentelemetry.sdk.trace.internal.data.ExceptionEventData;

public class RegisterResult extends ProjectSpecificationMethod {
	
	public  RegisterResult(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
	} 
	
	
	public RegisterResult validateSignup() {
		
		
		String expectedId = "PRODUCT STORE";
		String actualId = driver.findElement(By.id("nava")).getText();
		
		if(expectedId.equalsIgnoreCase(actualId)) {
			
			System.out.println("Signup Successful");
			
		}else {
			
			System.out.println("Signup Failed");
		}
		
		return this;
	}

}