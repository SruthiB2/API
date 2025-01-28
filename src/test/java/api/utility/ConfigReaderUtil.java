package api.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderUtil {
	
	/*
	 * Example for encapsulation. Declaring the fields as private and creating
	 * the methods where the private fields were used as public so that any other
	 * class cannot make use or modify the private variable but, we can read the 
	 * private variable content through public methods.
	 */
	private Properties prop;
	public Properties init_properties() {
		prop = new Properties();
		String filePath = ".\\src\\test\\resources\\config\\config.properties";
		try {
			FileInputStream fis = new FileInputStream(filePath);
				prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
