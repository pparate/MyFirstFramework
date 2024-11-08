package appium.mobileFramework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import appium.mobileFramework.pageObjects.ios.PageObject3;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBaseTest {
	IOSDriver driver;
	AppiumDriverLocalService service;
	PageObject3 pageObject3;
	
	@BeforeClass
	public void configureAppium() {
		service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//nodu_modules//appium//build////lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 13");
		options.setApp("");
		options.setPlatformName("iOS");
		options.setPlatformVersion("15.2");
		options.setAutomationName("XCUITest");
		options.setWdaLaunchTimeout(Duration.ofMinutes(2));
		
		//browser
		options.setCapability("browserName", "Safari");
		
		driver = new IOSDriver(service, options);
		pageObject3 = new PageObject3(driver);
		service.stop();
		
	}
	
	@AfterMethod
	@AfterClass
	public void tearDown() {
		service.stop();
		driver.quit();
	}


}
