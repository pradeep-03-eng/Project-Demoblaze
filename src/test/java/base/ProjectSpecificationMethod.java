package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.UtilityClass;

public class ProjectSpecificationMethod extends UtilityClass {

	@BeforeSuite
	public void reportInitialization() {
		
		String path = "C:\\Users\\DELL\\eclipse-workspace\\MiniProject2-guvi\\demoblazereport";
		//To create report in the given location
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Demoblaze Report");
		
		//To capture test data
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@BeforeClass
	public void testDetails() {
		
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor("Pradeep Kumar");
		
	}
	
	
	@Parameters({"url","browser"})
	@BeforeMethod
	public void launchandLoadURL(String url, String browser) {
		
		browserLaunch(browser, url);
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
	    driver.quit(); 
	}
	
	
	@AfterSuite
	public void reportclose() {
		
		extent.flush();
		
	}

}

