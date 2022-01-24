//'Tap' Gesture . Similar for Press,long press is the below code.
package hybridAppDemo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class tapDemo {
	AndroidDriver driver;
  @Test
  public void f() {
	  System.out.println("App opened");
	  AndroidElement btn = (AndroidElement)driver.findElementByXPath("//android.widget.TextView[@text='Battery']");
	  ElementOption(btn);

  }
  public void ElementOption(AndroidElement androidElement)
  {
	  new TouchAction(driver)
	  .tap(tapOptions().withElement(element(androidElement)))
	  .waitAction(waitOptions(Duration.ofSeconds(12))).perform();
	  
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
