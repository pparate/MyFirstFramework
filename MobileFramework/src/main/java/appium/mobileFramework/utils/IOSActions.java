package appium.mobileFramework.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;

public class IOSActions extends AppiumUtils {

	IOSDriver driver;

	public IOSActions(IOSDriver driver) {
		super(driver);
		this.driver = driver;
	}

//	MobileElement

//	DefaultGenericMobileElement class has been removed completely together with its descendants (MobileElement, IOSElement, AndroidElement etc.). Use WebElement instead.
//	Due to the above change the page factory is now only creating elements that are instantiated from RemoteWebElement and implement WebElement interface.
//	If you used some special methods that MobileElement or its descendants provided then change these:
//	replaceValue has been moved to the corresponding AndroidDriver instance and is called now replaceElementValue
//	use sendKeys method of WebElement interface instead of setValue.

	public void iosScroll(WebElement element) {
		element = driver.findElement(AppiumBy.id("OptionCellInformationSection2Row10"));

		HashMap<String, Object> params = new HashMap<>();
		// params.put("elementId", ((RemoteWebElement)element).getId());
		params.put("name", "OptionCellInformationSection2Row10");

		// params.put("direction", "down");
		params.put("toVisible", true);

		driver.executeScript("mobile: scroll", params);
	}

	public void iosSwipe(WebElement element) {
		element = driver.findElement(AppiumBy.id("LongTextCellSection0Row0"));

		HashMap<String, Object> params = new HashMap<>();
		params.put("elementId", ((RemoteWebElement) element).getId());

		params.put("direction", "up");
		// params.put("velocity", 2500);

		driver.executeScript("mobile: swipe", params);
	}

	public void pinch(WebElement element, int scale) {
		element = driver.findElement(AppiumBy.id("LongTextCellSection0Row0"));

		HashMap<String, Object> params = new HashMap<>();
		params.put("elementId", ((RemoteWebElement) element).getId());

		params.put("scale", scale);
		params.put("velocity", 2500);

		driver.executeScript("mobile: pinch", params);
	}

	public void doubleTab(WebElement element) {
		element = driver.findElement(AppiumBy.id("LongTextCellSection0Row0"));

		HashMap<String, Object> params = new HashMap<>();
		params.put("elementId", ((RemoteWebElement) element).getId());

		// params.put("x", 100);
		// params.put("y", 100);

		driver.executeScript("mobile: doubleTap", params);
	}

	public void iosLongPress(WebElement element) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("duration", 5);
		params.put("elementId", ((RemoteWebElement) element).getId());
		// params.put("x", 100);
		// params.put("y", 100);
		driver.executeScript("mobile:touchAndHold", params);

	}

	public void twoFingerTap(WebElement element) {
		HashMap<String, Object> params = new HashMap<>();

		params.put("elementId", ((RemoteWebElement) element).getId());

		driver.executeScript("mobile: twoFingerTap", params);

	}

	public void tap(WebElement element) {
		HashMap<String, Object> params = new HashMap<>();

		params.put("elementId", ((RemoteWebElement) element).getId());
		params.put("x", 100);
		params.put("y", 100);

		driver.executeScript("mobile: tap", params);

	}

	public void dragFromToForDuration(WebElement element) {
		HashMap<String, Object> params = new HashMap<>();

		params.put("elementId", ((RemoteWebElement) element).getId());
		params.put("duration", 100);
		params.put("fromX", 100);
		params.put("fromY", 100);
		params.put("toX", 100);
		params.put("toY", 100);

		driver.executeScript("mobile: dragFromToForDuration", params);

	}

	public void selectPickerWheelValue(WebElement element) {
		HashMap<String, Object> params = new HashMap<>();

		params.put("elementId", ((RemoteWebElement) element).getId());// element of type XCUIElementTypePickerWheel
		params.put("offset", 100);
		params.put("order", "next");// previous

		driver.executeScript("mobile: selectPickerWheelValue", params);

	}

	// same for android as well works with androiddriver or iosdriver only
	public void rotateDevice() {
		driver.rotate(new DeviceRotation(0, 0, 0));
		driver.rotate(ScreenOrientation.LANDSCAPE);
		driver.rotate(ScreenOrientation.PORTRAIT);
	}

	// same for android as well works with androiddriver or iosdriver only
	public void setClipboard() {

		try {
			driver.setClipboardImage(new BufferedImage(0, 0, 0));
			driver.setClipboardText("");
			driver.setClipboardUrl(new URL(""));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getClipboard() {

		try {
			driver.getClipboardImage();
			driver.getClipboardUrl();
			driver.getClipboardText();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
