package hybridAppDemo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity; //Required
import io.appium.java_client.android.AndroidDriver;

public class demoScreenshot {
	AndroidDriver driver;
  @Test
  public void f() throws IOException {
	  File scr= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(scr, new File("C:\\AppiumScreenshots\\" +"app.png"));
  }
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
