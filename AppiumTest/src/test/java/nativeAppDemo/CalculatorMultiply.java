/*Steps:
	1)type in command prompt 'uiautomatorviewer' and launch it
	2) open the app in emulator and take screenshot in uiautomator tool
	3) note the locators from the tool
	4)Run the appium in Simple mode and then run code in eclipse*/
/*Below program makes android calulator multiply 6*2 using xpath*/
package nativeAppDemo;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

/*xpath can be created for android elements using below combination:
1) xpath using class and text attribute
Ex: //android.widget.Button[@text='6']
2)using class, contains and resource-id
Ex: //android.widget.Button[contains(@resource-id,'com.android.calculator2:id/digit_2')]
3) using class text and index
Ex: //android.widget.Button[@text='2' and @index='7']
4)using class and content desc
Ex: //android.widget.Button[@content-desc='equals']
*/
public class CalculatorMultiply 
{
	static AndroidDriver driver; 
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.0");
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		System.out.println("App opened successfully");
		driver.findElementByXPath("//android.widget.Button[@text='6']").click();
		driver.findElementByXPath("//android.widget.Button[@text='×']").click();
		driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'com.android.calculator2:id/digit_2')]").click();		
		driver.findElementByXPath("//android.widget.Button[@text='=']").click();
		assertEquals(driver.findElementById("com.android.calculator2:id/result").getText(),"12");
		driver.closeApp();

}
}
