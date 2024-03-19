package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {

	public  File props;
	public FileInputStream props1;

	public  String readfile(String s) throws IOException {
		 props = new File("C:\\Users\\DELL\\git\\WebEcoomerce\\WebAutomation\\Config.Properties");
		props1 = new FileInputStream(props);
		Properties prop2 = new Properties();
		prop2.load(props1);

		String result = prop2.getProperty(s);
		
		return result;

	}

}
