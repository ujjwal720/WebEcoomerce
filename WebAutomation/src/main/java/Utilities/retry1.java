package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retry1 implements IRetryAnalyzer {

	int counter = 0;
	int limit = 3;

	@Override
	public boolean retry(ITestResult result) {

		if (counter < limit) {

			counter++;

			return true;
		}
		result.setStatus(ITestResult.FAILURE);
		System.out.println("Maximum retry limit reached");
		return false;
	}

}
