/*Steps: 
	1)Open chrome in emulator and type 'chrome://inspect/#devices' in local system chrome and then click on inspect
	  and find element locators OR enter website in system chrome and inspect like normally the locators.
    2)write code in eclipse as below
	3)Search for chrome version in emulator and download its chromedriver
	4)open appium tool and go to advanced and give chrome.exe path in Chromedriverbinarypath
	  and start the server.
	5)Run the code in eclipse and run the code and see the launch in emulator*/
	

package mobileWebDemo;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class Herokulogin {
  
	AndroidDriver driver;
  @BeforeTest
  public void beforeTest() throws MalformedURLException {
	  DesiredCapabilities cap= new DesiredCapabilities();
	  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	  cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
	  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	  cap.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
	  cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "1000");
	  
	  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
  }

  @Test
  public void login() throws InterruptedException {
	  driver.get("https://the-internet.herokuapp.com/login");
	  System.out.println("Site Opened");
	  
	  driver.findElementById("username").sendKeys("tomsmith");
	  driver.findElementById("password").sendKeys("SuperSecretPassword!");
	  driver.findElementByClassName("radius").click();
	  Thread.sleep(3000);
	  driver.findElementByPartialLinkText("Logout").click();
  }
  
  @AfterTest
  public void afterTest() {
	  driver.closeApp();
  }

}
