package PageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableMethods.Methods;

public class ProductsPage extends Methods {

	public WebDriver driver;

	public ProductsPage(WebDriver driver) {

		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	Methods x = new Methods(driver);

	@FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[1]/a")
	public WebElement women;

	@FindBy(xpath = "//input[@id='search_query_top']")
	public WebElement search;

	@FindBy(xpath = "//button[@name='submit_search']")
	public WebElement searchbutt;

	@FindBy(xpath = "//span[@class='price product-price' and @itemprop='price']")
	List<WebElement> elements;

	@FindBy(xpath = "//select[@id='selectProductSort']")
	WebElement ui;

	@FindBy(xpath = "//div[@class='product-image-container']/a/img")
	List<WebElement> elementsn;

	@FindBy(xpath = "(//div[@class='product-count'])[1]")
	WebElement product_count;

	@FindBy(xpath = "//span[@class='heading-counter']")
	WebElement counts3;

	public String verifyText() {

		try {

			return women.getText();

		}

		catch (Exception e) {

			e.printStackTrace();

			return "Error occured in test case";

		}

	}

	public void search(String s) {
		try {
			search.sendKeys(s);

		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void searchbutton() {

		try {

			searchbutt.click();

		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void clear(WebElement search) {

	}

	public void addtocart() {

	}

	public boolean sort() {

		boolean resultant = false;
		List<Integer> actual = new ArrayList<Integer>();
		List<Integer> results = new ArrayList<Integer>();
		int count = elements.size();
		System.out.println(count);
		int count1 = 0;
		for (int i = 0; i <= elements.size() - 1; i++) {

			x.movetoelement(elementsn.get(i), this.driver);

			String start = elements.get(i).getText();
			String start2 = start.substring(1);
			System.out.println(start2);

			actual.add(Integer.parseInt(start2));
			results.add(Integer.parseInt(start2));

		}

		Collections.sort(results);

		System.out.println(results);
		System.out.println(actual);

		for (int j = 0; j <= results.size() - 1; j++) {

			if (actual.get(j) == results.get(j)) {

				count++;

			}

		}

		if (count == count1) {

			return true;
		}

		else {

			return false;

		}

	}

	public void clickselect() {

		try {
			ui.click();
			x.SelectByindex(1, ui);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public String getcount() {
		try {
			return x.getetext(product_count);

		}

		catch (Exception e) {

			return "Exception occured";
		}
	}

	public String getcountheader() {

		try {
			return x.getetext(counts3);

		}

		catch (Exception e) {

			return "Exception occured";

		}

	}

}
