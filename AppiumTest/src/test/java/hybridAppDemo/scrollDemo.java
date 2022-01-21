//scroll gesture
package hybridAppDemo;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class scrollDemo {
	AndroidDriver driver;
	@Test
	public void za()
	{
		System.out.println("App Opened:Full Text");
		scrollToExactElement("System");
		//driver.findElement(MobileBy.AccessibilityId("System")).click(); //'content-desc'(in uiautomaotorviewer) is AccessibilityId
		//driver.findElement(MobileBy.AndroidUIAutomator("System")).click(); //AndroidUIAutomator is the 'text' of element(in uiautomatorviewer)
		driver.findElementByXPath("//android.widget.TextView[@text='System']").click();
		System.out.println("Clicked on System");
		scrollToElement("Sys");   //partial text or partial link
	}
	
	@Test
	public void fnc()
	{
		System.out.println("App Opened:Partial LinkText");
		scrollToElement("Sys");   //partial text or partial link
		driver.findElementByXPath("//android.widget.TextView[@text='System']").click();
		System.out.println("Clicked on System");
		
	}
	
	//linktext
	public void scrollToExactElement(String str)
	{
		((AndroidDriver<MobileElement>)driver).findElement(MobileBy.AndroidUIAutomator(  
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
						+str+"\").instance(0))"));
	}
	//partiallinktext
	public void scrollToElement(String str) {
		((AndroidDriver<MobileElement>)driver).findElement(MobileBy.
				AndroidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
								+str+"\").instance(0))")); }


	@BeforeTest
	public void beforeTest() throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.0");
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("appPackage", "com.android.settings");
		cap.setCapability("appActivity", "com.android.settings.Settings");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.closeApp();
	}

}
