package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configur {

	public Properties prop;

	public  Properties initialized_prop() {
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(
						"./src/test/resources/driver_confi/confii.properties");
				prop.load(file);
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();

			}
			return prop;
		}
	}




