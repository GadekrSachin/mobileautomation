package test;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class calculator {

	public static AppiumDriver<MobileElement> driver;

	public static void main(String[] args) {
		launch();

	}

	public static AppiumDriver<MobileElement> launch() {

		try {

			URL appiumServerUrl = new URL("http://localhost:4723");

			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
			desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "4d59fb4e");
			desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			desiredCapabilities.setCapability("appPackage", "com.oneplus.calculator");
			desiredCapabilities.setCapability("appActivity", "com.oneplus.calculator.Calculator");
			desiredCapabilities.setCapability("appium:noReset", true);
			desiredCapabilities.setCapability("appium:fullReset", false);
			desiredCapabilities.setCapability("appium:ignoreHiddenApiPolicyError", true);
			desiredCapabilities.setCapability("appium:disableWindowAnimation", true);

			driver = new AndroidDriver<>(appiumServerUrl, desiredCapabilities);
			driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);

			System.out.println("Application is starting............. ");
//in appium inspector use this capabillities 
//			{
//				  "platformName": "Android",
//				  "appium:deviceName": "4d59fb4e",
//				  "appium:platformVersion": "12",
//				  "appium:automationName": "UiAutomator2",
//				  "appium:appPackage": "com.android.settings",
//				  "appium:appActivity": "com.android.settings.Settings",
//				  "appium:noReset": "true",
//				  "appium:fullReset": "false",
//				  "appium:ignoreHiddenApiPolicyError": "true"
//				}
			List<MobileElement> buttons = driver.findElements(By.className("android.widget.Button"));

			String num1 = "8";
			System.out.println("Total buttons found: " + buttons.size());

			for (int i = 0; i < buttons.size(); i++) {
				String text = buttons.get(i).getText();
				System.out.println("Button " + (i + 1) + ": " + text);

				if (text.equals(num1)) {
					buttons.get(i).click();
					System.out.println("✅ Clicked on button with text 8 (Button " + (i + 1) + ")");
					break;
				}
			}

			List<MobileElement> imageButtons = driver.findElements(By.className("android.widget.ImageButton"));

			String sign = "plus";

			System.out.println("Total ImageButtons found: " + imageButtons.size());

			for (int i = 0; i < imageButtons.size(); i++) {
				String contentDesc = imageButtons.get(i).getAttribute("content-desc");
				System.out.println("Button " + (i + 1) + ": " + contentDesc);

				if (contentDesc != null && contentDesc.equalsIgnoreCase(sign)) {
					imageButtons.get(i).click();
					System.out.println("✅ Clicked on PLUS button (Button " + (i + 1) + ")");
					break;
				}
			}

			List<MobileElement> buttons2 = driver.findElements(By.className("android.widget.Button"));
			String num2 = "2";
			System.out.println("Total buttons found again: " + buttons2.size());

			for (int i = 0; i < buttons2.size(); i++) {
				String text = buttons2.get(i).getText();
				System.out.println("Button " + (i + 1) + ": " + text);

				if (text.equals(num2)) {
					buttons2.get(i).click();
					System.out.println("✅ Clicked on button with text " + num2 + " (Button " + (i + 1) + ")");
					break;
				}
			}

			List<MobileElement> imageButtons2 = driver.findElements(By.className("android.widget.ImageButton"));
			String sign2 = "equal";
			System.out.println("Total ImageButtons found: " + imageButtons2.size());

			for (int i = 0; i < imageButtons2.size(); i++) {
				String contentDesc2 = imageButtons2.get(i).getAttribute("content-desc");
				System.out.println("Button " + (i + 1) + ": " + contentDesc2);

				if (contentDesc2 != null && contentDesc2.equalsIgnoreCase(sign2)) {
					imageButtons2.get(i).click();
					System.out.println("✅ Clicked on PLUS button (Button " + (i + 1) + ")");
					break;
				}
			}
			System.out.println("All is Pass.....");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;

	}

}
