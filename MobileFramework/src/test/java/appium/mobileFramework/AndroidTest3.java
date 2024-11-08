package appium.mobileFramework;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import appium.mobileFramework.pageObjects.android.PageObject1;
import appium.mobileFramework.pageObjects.android.PageObject2;
import io.appium.java_client.android.Activity;

public class AndroidTest3 extends AndroidBaseTest2{
	

	
	@Test()
	public void testCase1() throws InterruptedException {
		
		System.out.println("test case 1 device 3");
		Thread.sleep(5000);
	}
	
	@Test()
	public void testCase2() throws InterruptedException {
		
		System.out.println("test case 2 device 3");
		Thread.sleep(5000);
	}


}
