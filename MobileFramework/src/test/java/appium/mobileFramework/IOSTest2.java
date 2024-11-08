package appium.mobileFramework;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appium.mobileFramework.pageObjects.android.PageObject1;
import appium.mobileFramework.pageObjects.android.PageObject2;
import io.appium.java_client.android.Activity;

public class IOSTest2 extends IOSBaseTest2{
	

	
	@Test
	public void testCase1() throws InterruptedException {
		
		System.out.println("Testcase 1 device 1");
		Thread.sleep(3000);

		
	}
	
	@Test
	public void testCase2() throws InterruptedException {
		
		System.out.println("Testcase 2 device 1");
		Thread.sleep(3000);

		
	}

}
