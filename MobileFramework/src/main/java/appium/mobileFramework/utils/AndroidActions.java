package appium.mobileFramework.utils;

import static java.lang.Math.floor;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.clipboard.ClipboardContentType;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidActions extends AppiumUtils {

	AndroidDriver driver;

	public AndroidActions(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}

//	MobileElement

//	DefaultGenericMobileElement class has been removed completely together with its descendants (MobileElement, IOSElement, AndroidElement etc.). Use WebElement instead.
//	Due to the above change the page factory is now only creating elements that are instantiated from RemoteWebElement and implement WebElement interface.
//	If you used some special methods that MobileElement or its descendants provided then change these:
//	replaceValue has been moved to the corresponding AndroidDriver instance and is called now replaceElementValue
//	use sendKeys method of WebElement interface instead of setValue.

	public WebElement scrollToText(String text) {
		return driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + text
						+ "\"))"));

	}

	public WebElement scrollToTextContains(String text) {
		return driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().textContains(\"" + text + "\"))"));

	}

	public WebElement scrollToId(String id) {
		return driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().resourceIdMatches(\".*id.*\"))"));

	}

	public void androidScrollUsingJavsScript(WebElement element) {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put("elementId", ((RemoteWebElement) element).getId());
		parameters.put("direction", "up");
		parameters.put("percent", 0.5);

		driver.executeScript("mobile:scrollGesture", parameters);

	}

	public void androidSwipeUsingJavsScript(WebElement element) {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put("elementId", ((RemoteWebElement) element).getId());
		parameters.put("direction", "left");
		parameters.put("percent", 0.5);

		driver.executeScript("mobile:swipeGesture", parameters);

	}

	public void longPress(WebElement element) {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put("elementId", ((RemoteWebElement) element).getId());
		parameters.put("duration", 2000);

		driver.executeScript("mobile:longClickGesture", parameters);

	}

	Dimension window = driver.manage().window().getSize();
	int width = window.getWidth();
	int height = window.getHeight();

	public void dragGesture() {

		int halfX = (int) floor(width / 2);
		int halfY = (int) floor(height / 2);

		// 147 - height to which you want to drag up
		int endY = (halfY - 147);

		WebElement element = driver.findElement(AppiumBy.id(""));
		HashMap<String, Object> params = new HashMap<>();
		// params.put("elementId", ((RemoteWebElement) element).getId());
		params.put("startX", halfX);
		params.put("startY", halfY);
		params.put("endX", halfY);
		params.put("endY", endY);
		// params.put("speed", 150);

		driver.executeScript("mobile: dragGesture", params);

	}

	public void scrollGesture() {

		int halfX = (int) floor(width / 2);
		int halfY = (int) floor(height / 2);

		WebElement element = driver.findElement(AppiumBy.id(""));
		HashMap<String, Object> params = new HashMap<>();
		// params.put("elementId", ((RemoteWebElement) element).getId());
		params.put("left", halfX);
		params.put("top", halfY);
		params.put("width", 147);
		params.put("height", 147);
		// params.put("speed", 150);
		params.put("percent", 1.0);
		params.put("direction", "down");

		driver.executeScript("mobile: scrollGesture", params);

	}

	public void swipeGesture() {

		int halfX = (int) floor(width / 2);
		int halfY = (int) floor(height / 2);

		WebElement element = driver.findElement(AppiumBy.id(""));
		HashMap<String, Object> params = new HashMap<>();
		// params.put("elementId", ((RemoteWebElement) element).getId());
		params.put("left", halfX);
		params.put("top", halfY);
		params.put("width", 0);
		params.put("height", 300);
		// params.put("speed", 150);
		params.put("percent", 1.0);
		params.put("direction", "up");

		driver.executeScript("mobile: swipeGesture", params);

	}

	public void flingGesture() {

		int halfX = (int) floor(width / 2);
		int halfY = (int) floor(height / 2);

		WebElement element = driver.findElement(AppiumBy.id(""));
		HashMap<String, Object> params = new HashMap<>();
		// params.put("elementId", ((RemoteWebElement) element).getId());
		params.put("left", halfX);
		params.put("top", halfY);
		params.put("width", 0);
		params.put("height", 300);
		params.put("speed", 150);
		params.put("direction", "down");

		driver.executeScript("mobile: flingGesture", params);

	}

	// For vertical scroll
	// new UiScrollable(new
	// UiSelector().scrollable(true)).setAsVerticalList().scrollForward()
	// For Horizontal scroll
	// new UiScrollable(new
	// UiSelector().scrollable(true)).setAsHorizontalList().scrollForward()

	// scrollForward (moves exactly one view)
	public void scrollForward() {
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
	}

	// scrollBackward (moves exactly one view)
	public void scrollBsckward() {
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
	}

	// scrollToBeginning (moves exactly by one view. 10 scrolls max)
	public void scrollToEnd() {
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
	}

	// scrollToEnd (moves exactly by one view. 10 scrolls max)
	public void scrollToBeginning() {
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(10)"));
	}

	public void rotateDevice() {
		driver.rotate(new DeviceRotation(0, 0, 0));
		driver.rotate(ScreenOrientation.LANDSCAPE);
		driver.rotate(ScreenOrientation.PORTRAIT);
	}

	public void setClipboard() {

		driver.setClipboardText("");

	}

	public void getClipboard() {

		driver.getClipboardText();

	}
	
	//doesnt work in ios, no options
	public void pressKey() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

}
