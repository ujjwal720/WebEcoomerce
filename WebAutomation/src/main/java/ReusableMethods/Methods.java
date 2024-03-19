package ReusableMethods;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Methods {

	WebDriver driver;

	public Methods(WebDriver driver) {

		this.driver = driver;

	}

	public void SelectByindex(int i, WebElement element) {

		Select a = new Select(element);

		try {

			a.selectByIndex(i);

		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void implicitwait(int time) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public String getetext(WebElement element) {

		String text = null;

		try {

			text = element.getText();

			return text;

		}

		catch (Exception e) {

			e.printStackTrace();
		}
		return text;

	}

	public String gettittle() {

		return driver.getTitle();
	}

	public void sendkeys(String s, WebElement element) {

		element.sendKeys(s);

	}

	public void fluentwait(WebElement element) {

		WebDriverWait a = new WebDriverWait(driver, Duration.ofSeconds(10));
		a.until(ExpectedConditions.visibilityOf(element));

	}

	public void click(WebElement element) {

		element.click();

	}

	public void Executor(String scroll) {

		JavascriptExecutor abc = ((JavascriptExecutor) driver);
		abc.executeScript(scroll, "");

	}

	public void movetoelement(WebElement element, WebDriver driver) {

		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();

	}

	public void movetoelements(WebElement r) {

	}

}
