package appium.mobileFramework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import appium.mobileFramework.pageObjects.android.PageObject1;
import appium.mobileFramework.pageObjects.ios.PageObject3;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBaseTest2 {
	
	
	public static IOSDriver driver;
	 

		
	@BeforeTest
//	@Parameters({"port","device"})
	public void configureAppium() throws MalformedURLException {
		//service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//nodu_modules//appium//build////lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		//service.start();
		
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 14");
		options.setApp("//Users//pratik.parate//Documents//TechInitiative_Apps//wdioNativeDemoApp.app");
		options.setPlatformName("iOS");
		options.setPlatformVersion("16.2");
		options.setAutomationName("XCUITest");
		options.setWdaLaunchTimeout(Duration.ofMinutes(2));
		
		//browser
		//options.setCapability("browserName", "Safari");
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
		
		//driver = new IOSDriver(service, options);
		//pageObject3 = new PageObject3(driver);
		//service.stop();
		
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
		
		//driver.context("WEBVIEW_com.wdiodemoapp");
		driver.findElement(AppiumBy.iOSNsPredicateString("label == \"Toggle navigation bar\"")).click();
		
		
	}
	
	@AfterMethod
	@AfterClass
	public void tearDown() {
		//service.stop();
		driver.quit();
	}


}
