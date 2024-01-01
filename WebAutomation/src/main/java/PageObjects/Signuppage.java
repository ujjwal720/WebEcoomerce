package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableMethods.Methods;
import Utilities.PropertiesHelper;

public class Signuppage extends Methods {

	public WebDriver driver;

	public Signuppage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	PropertiesHelper qa = new PropertiesHelper();
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='passwd']")
	WebElement pass;
	@FindBy(xpath = "//button[@id='SubmitLogin']")
	WebElement button;

	@FindBy(xpath = "//div[@class='header_user_info']/a/span")
	WebElement name;

	Methods method_sa = new Methods(driver);

	public void email() throws IOException {

		method_sa.sendkeys(qa.readfile("email"), email);
	}

	public void password() throws IOException {

		method_sa.sendkeys(qa.readfile("password"), pass);
	}

	public void signin() {

		button.click();

	}

	public String name() {

		return name.getText();

	}

}
