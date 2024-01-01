package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableMethods.Methods;

public class indexPage extends Methods {

	WebDriver driver;

	public indexPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	Methods a = new Methods(driver);

	@FindBy(xpath = "//a[@class='login']")
	WebElement signIn;

	public Signuppage ClickonSign() {

		a.click(signIn);
		
		return new Signuppage(driver);

	}

	public String gettext() {

		return a.getetext(signIn);

	}

	public void getsymbol() {

	}
	
	
	
	

}
