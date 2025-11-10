package com.factory;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import Utility.configur;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base_driver {

	configur confi = new configur();
	AppiumDriver<MobileElement> driver;
	public static ThreadLocal<AppiumDriver<MobileElement>> tlDriver = new ThreadLocal<>();

	public AppiumDriver<MobileElement> initializeDriver(String platformName) {

		try {

			DesiredCapabilities caps = new DesiredCapabilities();
			String plateform = confi.initialized_prop().getProperty("platform");
			System.out.println("plateform from base class : " + plateform);

			if (platformName.equalsIgnoreCase(plateform)) {

				caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
				caps.setCapability(MobileCapabilityType.DEVICE_NAME, "phone");
				caps.setCapability(MobileCapabilityType.APP, "C://Users//SHUBH//Downloads//bitbar-sample-app.apk");
				caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

//				caps.setCapability("platformName", "Android");
//				caps.setCapability("deviceName", "4d59fb4e");
//				caps.setCapability("platformVersion", "12");	
//				caps.setCapability(plateform, false);
//				caps.setCapability("automationName", "UiAutomator2");
//				caps.setCapability("appPackage", "com.android.calculator2");
//				caps.setCapability("appActivity", "com.android.calculator2.Calculator");
//				caps.setCapability("noReset", true);
//				caps.setCapability("fullReset", false);
//				caps.setCapability("ignoreHiddenApiPolicyError", true);

				URL serverurl = new URL("http://127.0.0.1:4723");
				driver = new AndroidDriver<>(serverurl, caps);

				driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
				tlDriver.set(driver);

				System.out.println("✅ Android driver initialized successfully!");
			}

			else if (platformName.equalsIgnoreCase(plateform)) {
				System.out.println("for IOS");
			}

			else {
				throw new RuntimeException("❌ Platform not supported: " + platformName);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail...");
		}
		return getDriver();
	}

	public static synchronized AppiumDriver<MobileElement> getDriver() {
		return tlDriver.get();
	}

}
