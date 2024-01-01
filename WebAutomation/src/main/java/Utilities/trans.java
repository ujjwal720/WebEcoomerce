package Utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class trans implements IAnnotationTransformer {
	
	 public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	        // Set the retry analyzer for the test method
	        annotation.setRetryAnalyzer(retry1.class);
	    }


}
