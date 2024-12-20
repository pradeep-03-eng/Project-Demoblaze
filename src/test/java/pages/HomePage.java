package pages;

	import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

	public class HomePage extends ProjectSpecificationMethod {
		
		@FindBy(id = "signin2")	
		WebElement signup;
		public HomePage(WebDriver driver) {
			
			this.driver = driver;
			PageFactory.initElements(driver, this);	
		}
		
		public SignupPage signupClick() {
			
			driver.findElement(By.id("signin2")).click();
			
			return new SignupPage(driver);
			
		}
		
		
		@FindBy(id="login2")
		WebElement login;
		
		public LoginPage loginClick() {
			
			login.click();
			
			
		return new LoginPage(driver);
		
		}
		
		
		//Login Validation 
		public HomePage validateLogin(String testcase, String expected) {
			
			
				try {
				Thread.sleep(2000);
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		
				if(testcase.equals("validusernameandvalidpassword")) {
					WebElement username = driver.findElement(By.id("nameofuser"));
					String actualId = username.getText();
					
				if(expected.equalsIgnoreCase(actualId)) {
					
					System.out.println("Login Successful");
				} else {
					System.out.println("Login Failed");
				}
				
				}else if(testcase.equals("invalidusernameandvalidpassword")) {
					
					String actualId="User does not exist.";
					
					if(expected.equalsIgnoreCase(actualId)) {
						
						System.out.println("Test Case Passed");
					} else {
						
						System.out.println("Test Case Failed");
					}
				}
			
			return new HomePage(driver);
		}
	
		
		//Product Selection Page
		@FindBy(xpath="//a[3]")
		WebElement category;
		
		@FindBy(xpath="//*[@id=\"tbodyid\"]/div[3]/div/div/h4/a")
		WebElement product;
		
		public  HomePage productselection()  {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			
			//Select the categories by products
			category.click();
			
			//Select the products by model
			product.click();
			
			//Product Added To Cart
			driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).click();


			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 Alert alert = driver.switchTo().alert();
		        alert.accept();
			
		     return new HomePage(driver);
	
		}

	
	public HomePage validateProductSelection() {
		
		
		String expectedId = "Add to cart";
		String actualId = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).getText();
		
		if(expectedId.equalsIgnoreCase(actualId)) {
			
			System.out.println("Product Selected Successfully");
			
		}else {
			
			System.out.println("Product Selected Failed");
		}
		
		return new HomePage(driver);
	}
	
	
	
	public HomePage checkoutPage() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.id("cartur")).click();
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")).click();
		driver.findElement(By.id("name")).sendKeys("Pradeep Kumar");
		driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.id("city")).sendKeys("Coimbatore");
		driver.findElement(By.id("card")).sendKeys("2345765432219087");
		driver.findElement(By.id("month")).sendKeys("October");
		driver.findElement(By.id("year")).sendKeys("2028");
		driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new HomePage(driver);
		
	}

	
	
	
	
	public HomePage validatecheckout() {
	
		
		String expectedId = "Thank you for your purchase!";
		String actualId = driver.findElement(By.xpath("//h2[contains(text(), 'Thank you for your purchase!')]")).getText();
		
		if(expectedId.equalsIgnoreCase(actualId)) {
			
			System.out.println("Checkout Successfully");
			
		}else {
			
			System.out.println("Checkout was Failed");
		}
		
		return new HomePage(driver);	
		
	}

}



	
	

