package TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.ProductsPage;
import PageObjects.Signuppage;
import PageObjects.indexPage;
import Utilities.ExelUtilities;

public class TestCase01 extends Base {

	SoftAssert ass = new SoftAssert();
	Logger logs = Logger.getLogger("TestCase01");

	
	/*
	 * to sign in and verify username
	 */
	@Test(priority = 1)
	public void test1() {

		try {

			indexPage a = new indexPage(Base.driver);
			String l = a.gettext();
			a.ClickonSign();
			String yz = "Prachi Gupta";
			Signuppage d_a = new Signuppage(Base.driver);
			d_a.email();
			Base.Executor("window.scrollBy(0,400)");
			d_a.password();
			d_a.signin();

			Assert.assertEquals(d_a.name(), yz);
			logs.info("Testcase completed");
		}

		catch (Exception e) {

			e.printStackTrace();

			logs.info("Exception has occured");
			logs.info("Testcase as error");

		}

	}

	
	/*
	 * to search a product
	 */
	@Test(priority = 2)
	public void test2() {
		try {
			ProductsPage w = new ProductsPage(Base.driver);
			w.search("dress");
			w.searchbutton();

		}

		catch (Exception e) {

			e.printStackTrace();

		}
	}

	@Test(priority = 3, enabled = false)
	public void test3() throws InterruptedException {

		ProductsPage w = new ProductsPage(Base.driver);

		w.clickselect();
		Thread.sleep(5000);
		Base.Executor("window.scrollBy(0,600)");
		boolean x = w.sort();
		Assert.assertTrue(x);

	}

	
	/*
	 * to verify the number is same in test
	 */
	@Test(priority = 4)
	public void test4() {

		ProductsPage w = new ProductsPage(Base.driver);
		String l = w.getcount();
		String[] iu = l.split(" ");
		String actual = iu[5];
		String z = w.getcountheader();
		String[] iz = z.split(" ");
		String actual2 = iz[0];
		Assert.assertEquals(actual, actual2);
		logs.info("Test is passed");

	}

	public void test5() {
		
		
		

	}

	@DataProvider(name = "logindataProvider")
	public Object[][] logindataProvider() throws IOException {

		ExelUtilities a = new ExelUtilities();
		File aabc = new File("C:\\Users\\DELL\\Desktop\\LoginData.xlsx");
		int rows = a.getrowno(aabc) + 1;
		int cols = a.getcolno(aabc);

		Object[][] f = new Object[rows][cols];
		for (int i = 0; i <= rows - 1; i++) {

			for (int j = 0; j < cols; j++) {

				String result = a.ReadExcelFile(aabc, i, j);
				f[i][j] = result;

			}

		}

		return f;

	}

}
