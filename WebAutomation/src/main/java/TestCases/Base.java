package TestCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import Utilities.ListenerHelper;
import Utilities.PropertiesHelper;

public class Base {

	protected static WebDriver driver;

	String browser = "Chrome";

	@BeforeSuite
	public void setup() throws IOException {

		if (browser.equalsIgnoreCase("chrome")) {

	//	System.setProperty("webdriver.chrome.driver", "C:\\ch\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			PropertiesHelper b=new PropertiesHelper();
			String url = b.readfile("url");
			System.out.println(url);
			driver.get(url);
			ListenerHelper ty=new ListenerHelper(Base.driver);

		}
		

	}
	

	
	public static void Executor(String scroll) {

		JavascriptExecutor abc = ((JavascriptExecutor) driver);
		abc.executeScript(scroll, "");

	}

}
