package appium.mobileFramework.utils;

import java.io.File;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumUtils {
	
	AppiumDriver driver;
	
	@AndroidFindBy(id="")
	@iOSXCUITFindBy(id="")
	private WebElement element1;
	
	public AppiumUtils(AppiumDriver driver) {
		this.driver = driver;
	}
	
	public void commonMethod1() {
		
	}
	
	public void waitForElementToAppear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
	}
	
	
	public void scroll() {
		
		
	}
	

}
