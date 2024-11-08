package appium.mobileFramework;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import appium.mobileFramework.pageObjects.android.PageObject1;
import appium.mobileFramework.utils.AppiumUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AndroidBaseTest{
	
 
	AndroidDriver driver;
	AppiumDriverLocalService service;
	PageObject1 pageObject1;
	
	
	@BeforeTest
	public void configureAppium() {
		startAppium(4723);
//		UiAutomator2Options options = new UiAutomator2Options();
//		options.setDeviceName("Android Device");
//		options.setPlatformName("android");
//		options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//		options.setAppActivity("com.google.android.apps.nexuslauncher.NexusLauncherActivity");
//		options.setAppPackage("com.google.android.apps.nexuslauncher");
//		options.eventTimings();
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("appium:platformName", MobilePlatform.ANDROID);
		//cap.setCapability("appium:platformVersion", platform);
		cap.setCapability("appium:app", "/Users/pratik.parate/Documents/TechInitiative_Apps/Android-NativeDemoApp-0.4.0.apk");
		cap.setCapability("appium:deviceName","Android Device");
		cap.setCapability("appium:automationName","UiAutomator2");
		cap.setCapability("appium:appPackage","com.wdiodemoapp");
		cap.setCapability("appium:appActivity","com.wdiodemoapp.MainActivity");
		
		//for webview automation
	//	options.setChromedriverExecutable("chromedriver.exe path");
	//	options.setCapability("browserName", "Chrome");
		//not needed for already installed app
		//options.setApp("");
		

		
			try {
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//pageObject1 = new PageObject1(driver);
		
		
	}
	
    //////////
	//npm reinstall next step
	//Important --   in eclipse , need to set the android_home path , else we may get error like neither android_home nor android_sdk path exported
	
	public void startAppium(int port) {
		Map<String, String> env = new HashMap<String, String>(System.getenv());
	    env.put("NODE_PATH", "//usr//local//lib//node_modules");
	   
	    
		service = new AppiumServiceBuilder()
				//.withAppiumJS(new File("//Applications//Appium Server GUI.app//Contents//Resources//app//node_modules//appium//build//lib//main.js"))
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				//.withEnvironment(env)
				//.usingDriverExecutable(new File("/usr/local/bin/node"))
				.withIPAddress("127.0.0.1")
				.usingPort(port)
				.withArgument(GeneralServerFlag.BASEPATH,"/wd/hub")
				.withTimeout(Duration.ofSeconds(5))
				.build();
		//service.start();
		
		//driver.findElement(AppiumBy.accessibilityId(null));
		//driver.findElement(AppiumBy.className(null));
		//driver.findElement(AppiumBy.xpath(null));
		//driver.findElement(AppiumBy.id(null));
		//driver.findElement(AppiumBy.androidUIAutomator(null));
		
		
		//driver.findElement(AppiumBy.accessibilityId(null));
		
		
		
	}
	///opt/homebrew/lib/node_modules/appium/build/lib/main.js
	
	@AfterTest
	public void tearDown() {
		//service.stop();
		driver.quit();
	}

}
