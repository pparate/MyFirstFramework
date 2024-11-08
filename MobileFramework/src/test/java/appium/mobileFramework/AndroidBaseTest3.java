package appium.mobileFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import appium.mobileFramework.pageObjects.android.PageObject1;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AndroidBaseTest3{
	
 
	public static AndroidDriver driver;
 
	AppiumDriverLocalService service;
	PageObject1 pageObject1;

	@BeforeTest
	//public void configureAppium() {
	public void configureAppium() throws MalformedURLException {

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Android Device");
		options.setPlatformName(MobilePlatform.ANDROID);
		options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
		options.setAppActivity("com.wdiodemoapp.MainActivity");
		options.setApp("/Users/pratik.parate/Documents/TechInitiative_Apps/Android-NativeDemoApp-0.4.0.apk");
		options.setAppPackage("com.wdiodemoapp");		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
		
				
	}

		
	@Test
	public static void locators() throws InterruptedException {
//		driver.findElement(AppiumBy.accessibilityId(null));
//		driver.findElement(AppiumBy.className(null));
//		driver.findElement(AppiumBy.xpath(null));
//		driver.findElement(AppiumBy.id(null));
//		driver.findElement(AppiumBy.androidUIAutomator(null));	
		
		driver.findElement(AppiumBy.accessibilityId("Forms")).click();
		Thread.sleep(3000);	
		
		//text
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Active\"))")).click();;
		
		//textContains
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Active\"))")).click();;

		
		//Switch Context
		driver.findElement(AppiumBy.accessibilityId("Webview")).click();
		Thread.sleep(5000);
		System.out.println(driver.getContextHandles());
		
		driver.context("WEBVIEW_com.wdiodemoapp");
		driver.findElement(By.xpath("//div[@id=\"__docusaurus\"]/nav/div[1]/div[1]/button")).click();
		
		
	}
	
	

}
