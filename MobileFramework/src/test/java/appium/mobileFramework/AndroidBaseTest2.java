package appium.mobileFramework;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import appium.mobileFramework.pageObjects.android.PageObject1;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AndroidBaseTest2{
	
 private ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
 
	AppiumDriverLocalService service;
	PageObject1 pageObject1;

	public void setDriver(AppiumDriver driver) {
		this.driver.set(driver);
		
	}
	
	public AppiumDriver getDriver() {
		return this.driver.get();
	}

	// This setup is for parallel run
	
	@BeforeTest
	@Parameters({"port","device","platform","mjpeg"})
	//public void configureAppium() {
	public void configureAppium(String port,String device,String platform,String mjpeg) throws MalformedURLException {
		//startAppium(Integer.parseInt(port));
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(device);
		options.setPlatformName(MobilePlatform.ANDROID);
//		options.setPlatformVersion(platform);
		options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
		options.setAppActivity("com.google.android.apps.nexuslauncher.NexusLauncherActivity");
		options.setAppPackage("com.google.android.apps.nexuslauncher");
		options.eventTimings();
		options.setMjpegServerPort(Integer.parseInt(mjpeg));
		//options.setSystemPort(Integer.parseInt(port));
		options.setAdbExecTimeout(Duration.ofMillis(50000));
		
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability("platformName", MobilePlatform.ANDROID);
//		cap.setCapability("appium:platformVersion", platform);
//		cap.setCapability("appium:deviceName",device);
//		cap.setCapability("appium:automationName","UiAutomator2");
//		cap.setCapability("appium:appPackage","com.google.android.apps.nexuslauncher");
//		cap.setCapability("appium:appActivity","com.google.android.apps.nexuslauncher.NexusLauncherActivity");
//	//	cap.setCapability("mjpegServerPort", Integer.parseInt(mjpeg));
//	//	cap.setCapability("systemPort", Integer.parseInt(port));
//		cap.setCapability("adbExecTimeout", 50000);
		
		
		setDriver(new AndroidDriver(new URL("http://127.0.0.1:"+port+"/wd/hub"), options));
		
		//driver = new AndroidDriver(service.getUrl(),cap);
		
		//pageObject1 = new PageObject1(driver);
		
		
	}
	
	public void startAppium(int port) {
		//service = new AppiumServiceBuilder().withAppiumJS(new File("//Applications//Appium Server GUI.app//Contents//Resources//app//node_modules//appium//build//lib//main.js")).withIPAddress("127.0.0.1").usingPort(port).withArgument(GeneralServerFlag.BASEPATH,"/wd/hub").build();
		//service.start();
	}
	
	@AfterTest
	public void tearDown() {
		//service.stop();
		//getDriver().quit();
	}

}
