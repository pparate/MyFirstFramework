package appium.mobileFramework;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appium.mobileFramework.pageObjects.android.PageObject1;
import appium.mobileFramework.pageObjects.android.PageObject2;
import io.appium.java_client.android.Activity;

public class IOSTest1 extends IOSBaseTest{
	

	
	@Test
	public void testCase1() {
		
		pageObject3.setField("anyText");
		
		AssertJUnit.assertEquals("anyText", pageObject3.getField());
		

		
	}

}
