/*To install android application in emulator using below code.
Steps:
	1)create apps folder and paste the apk file to download
	2) and write below code 
	3) run appium and then run code and see launching in emulator*/
package hybridAppDemo;


import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class NewTest {
	AndroidDriver driver;
	@Test
	public void f() {
		System.out.println("App installed and opened");
	}
	@BeforeTest
	public void beforeTest() throws MalformedURLException {
		File app = new File(System.getProperty("user.dir")+"/apps/Login.apk");

		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.closeApp();
	}

}
