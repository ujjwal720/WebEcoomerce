package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import TestCases.Base;

public class ListenerHelper extends Base implements ITestListener {


	public ExtentSparkReporter io;
	ExtentReports	c = new ExtentReports();
	public ExtentTest abc;
	WebDriver driver;


	public ListenerHelper() {

	}
	
	public ListenerHelper(WebDriver driver) {
		
		this.driver=driver;
		

	}


	public void config() {
	

		String a = "C:\\Users\\DELL\\eclipse-workspace\\WebAutomation\\results.html";
		io = new ExtentSparkReporter(a);
		c.attachReporter(io);
		c.setSystemInfo("OS", "WINDOWS11");
		io.config().setDocumentTitle("Test Cases of Ecommerce");
		io.config().setReportName("Ujjwal");
	}

	
	// Invoked when a test is startedb.

	public void onStart(ITestContext Result) {
		config();
		System.out.println("Test is started");
		
	}

	// Invoked when a test is success
	@Override
	public void onTestSuccess(ITestResult result) {
       String name=result.getName();
		abc = c.createTest(name);
		abc.log(Status.PASS, MarkupHelper.createLabel("Name of the failed test case is: " + result.getName() ,ExtentColor.GREEN));
	

	}

	// Invoked when a test is failed
	@Override
	public void onTestFailure(ITestResult result) {

	
	

		if (Base.driver != null) {
			// Capture a screenshot when the test fails.
			
			File screenshotFile = ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.FILE);

			try {
				// Get the test case name.
				String testCaseName = result.getName();
				abc = c.createTest(testCaseName);
				abc.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + result.getName() ,ExtentColor.RED));
				// Generate a timestamp with date, time, and seconds.
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
				String timestamp = dateFormat.format(new Date());

				// Set the project directory to the specified path.
				String projectDirectory = "C:\\Users\\DELL\\eclipse-workspace\\WebAutomation\\";

				// Concatenate the test case name with the timestamp.
				String screenshotFileName = testCaseName + "_" + timestamp + ".png";
				String screenshotPath = projectDirectory + "screenshots\\" + screenshotFileName;

				// Create the directory to store the screenshots if it doesn't exist.
				File directory = new File(screenshotPath).getParentFile();

				if (!directory.exists()) {
					boolean created = directory.mkdirs(); // Create the directory if it doesn't exist.
					System.out.println("Directory created: " + created); // Debug statement
				}

				// Save the screenshot with the new filename.
				File destFile = new File(screenshotPath);
				FileUtils.copyFile(screenshotFile, destFile);
				System.out.println("projectDirectory: " + projectDirectory); // Debug statement
				System.out.println("screenshotPath: " + screenshotPath); // Debug statement
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("WebDriver is null");
		}

	}

	// Invoked when a test is skipped
	@Override
	public void onTestSkipped(ITestResult result) {
		String name=result.getName();
		abc = c.createTest(name);
		abc.log(Status.SKIP, MarkupHelper.createLabel("Name of the failed test case is: " + result.getName() ,ExtentColor.BLACK));
	

	}

	// Invoked when a test fails but is within success percentage
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onFinish(ITestContext context) {
        c.flush();
		System.out.println("Test finished");

	}

}
