package nativeAppDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class LoginAppDemo {
	static AndroidDriver driver; 
	
	public static void main(String[] args) throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.0");
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("appPackage", "com.appsgallery.sagar.loginregistrationexample");
		cap.setCapability("appActivity", "com.appsgallery.sagar.loginregistrationexample.MainActivity");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		System.out.println("App opened successfully");
		driver.findElementById("com.appsgallery.sagar.loginregistrationexample:id/editLogin").sendKeys("aakash");
		driver.findElementById("com.appsgallery.sagar.loginregistrationexample:id/editPasswordLogin").sendKeys("aakash");
		driver.findElementById("com.appsgallery.sagar.loginregistrationexample:id/login").click();
		driver.closeApp();
		
		System.out.println("App Closed");
	}

}
