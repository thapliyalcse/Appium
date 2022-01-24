//Below program helps in clicking android actual buttons like back and Home
package hybridAppDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey; //First mandatory class required for android key events
import io.appium.java_client.android.nativekey.KeyEvent; //Second mandatory class required for android key events

public class androidKeyEvents {
	AndroidDriver driver;
  @Test
  public void f() throws InterruptedException 
  {
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Display\")")).click();// MobileBy is best to use with locators as below line if uncommented will choose another menu while launching application 
	  //driver.findElementByXPath("//android.widget.TextView[@text='Display']").click();
	  System.out.println("Cicked on Display");
	  driver.findElementByXPath("//android.widget.TextView[@text='Sleep']").click();
	  System.out.println("Cicked on Sleep");
	  Thread.sleep(2000);
	  driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	  Thread.sleep(2000);
	  driver.pressKey(new KeyEvent().withKey(AndroidKey.HOME));
	  System.out.println("Reached to home page");
	     
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
