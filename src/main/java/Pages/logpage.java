package Pages;

import org.openqa.selenium.By;

import com.factory.Base_driver;

import Utility.configur;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class logpage {

	Base_driver basedriver = new Base_driver();
	configur confi = new configur();

	public AppiumDriver<MobileElement> driver;

	public logpage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public void i_open_the_calculator_app() {
		basedriver.initializeDriver(confi.initialized_prop().getProperty("platform"));
		System.out.println("done......");
	}
	
	public void write_something_and_click_button () throws InterruptedException {
		  
//		 
//		driver.findElement(By.id("com.bitbar.testdroid:id/editText1")).sendKeys("123");
//		driver.findElement(By.id("com.bitbar.testdroid:id/button1")).click();
//		Thread.sleep(3000);
	}

}
