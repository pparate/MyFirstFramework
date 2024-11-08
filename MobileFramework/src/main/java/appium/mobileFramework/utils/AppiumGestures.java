package appium.mobileFramework.utils;

import static java.lang.Math.floor;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumGestures {
	
	AppiumDriver driver;
	
	public AppiumGestures(AppiumDriver driver) {
		this.driver = driver;
	}
	
	public void scroll_Js(WebElement element,String direction,float percentage) {
		boolean isIOS = true;
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put("elementId", ((RemoteWebElement) element).getId());
		parameters.put("direction", direction);
		
		//ios
		if(isIOS) {
			driver.executeScript("mobile: scroll", parameters);			
	//android
		}else {		
			parameters.put("percent", percentage);
			driver.executeScript("mobile:scrollGesture", parameters);			
		}	
	}
	
	public void scroll_Js_ios(WebElement element,String direction) {
	

		HashMap<String, Object> params = new HashMap<>();
		params.put("name", "OptionCellInformationSection2Row10");	
		params.put("toVisible", true);

		driver.executeScript("mobile: scroll", params);
	}
	
	
	public void scroll_Js_Android(int width,int height,String direction,int speed) {

		int halfX = (int) floor(width / 2);
		int halfY = (int) floor(height / 2);

		HashMap<String, Object> params = new HashMap<>();
		params.put("left", halfX);
		params.put("top", halfY);
		params.put("width", width);
		params.put("height", height);
		params.put("speed", speed);
		params.put("percent", 1.0);
		params.put("direction", direction);

		driver.executeScript("mobile: scrollGesture", params);

	}
	
	public WebElement scrollToText_Android(String text) {
		return driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + text
						+ "\"))"));

	}

	public WebElement scrollToTextContains_Android(String text) {
		return driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().textContains(\"" + text + "\"))"));

	}

	public WebElement scrollToId_Android(String id) {
		return driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().resourceIdMatches(\".*id.*\"))"));

	}
	
	
	    // scrollForward (moves exactly one view)
		public void scrollForward_Android() {
			driver.findElement(
						AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
		}

		// scrollBackward (moves exactly one view)
		public void scrollBackward_Android() {
			driver.findElement(
						AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
		}

		// scrollToBeginning (moves exactly by one view. 10 scrolls max)
		public void scrollToEnd_Android(int noOfScrolls) {
			driver.findElement(
						AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd("+noOfScrolls+")"));
		}

		// scrollToEnd (moves exactly by one view. 10 scrolls max)
		public void scrollToBeginning_Android(int noOfScrolls) {
			driver.findElement(AppiumBy
						.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning("+noOfScrolls+")"));
		}
		
		
		public void swipe_Js(WebElement element,String direction,float percentage) {
			boolean isIOS = true;
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("elementId", ((RemoteWebElement) element).getId());
			parameters.put("direction", direction);
			
			//ios
			if(isIOS) {
				driver.executeScript("mobile: swipe", parameters);
			
			//android
			}else {
				parameters.put("percent", 0.5);
				driver.executeScript("mobile:swipeGesture", parameters);
			}
			
		}
		
		public void longPress(WebElement element,int duration) {
			boolean isIOS = true;
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("elementId", ((RemoteWebElement) element).getId());
			parameters.put("duration", duration);
			
			//ios
			if(isIOS) {

				driver.executeScript("mobile:touchAndHold", parameters);
			
			//android
			}else {
		
				driver.executeScript("mobile:longClickGesture", parameters);
			}
		}

		public void selectPickerWheelValue_IOS(WebElement element) {
			HashMap<String, Object> params = new HashMap<>();

			params.put("elementId", ((RemoteWebElement) element).getId());// element of type XCUIElementTypePickerWheel
			params.put("offset", 100);
			params.put("order", "next");// previous

			driver.executeScript("mobile: selectPickerWheelValue", params);

		}

	

}
