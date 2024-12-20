package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v128.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class UtilityClass {
	
public WebDriver driver;
public static Properties prop;
public static ExtentReports extent;
public static ExtentTest test;
public String testName, testDescription, testCategory,testAuthor;
	

	public void browserLaunch(String browsername, String url) {
		
		if(browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();	
		}else if(browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	}
	
	
	public void closeBrowser() {
	   closeBrowser(); 
	}
	
	public void SendKeysMethod(WebElement ele, String input) {
		
		ele.sendKeys(input);
		
	}

	public static void readFromPropFile(String filename) throws IOException {
		FileReader file = new FileReader("C:\\Users\\DELL\\eclipse-workspace\\MiniProject2-guvi\\src\\test\\resources\\TestData\\LoginTestData.properties");
		prop = new Properties();
		prop.load(file);
	
	}
	
	public String screenshot(String name) throws IOException {
		
		String path = "C:\\Users\\DELL\\eclipse-workspace\\MiniProject2-guvi\\Snap\\"+name+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
		
	}
}
