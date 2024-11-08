package appium.mobileFramework;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import appium.mobileFramework.pageObjects.android.PageObject1;
import appium.mobileFramework.pageObjects.android.PageObject2;
import io.appium.java_client.android.Activity;

public class AndroidTest1 extends AndroidBaseTest{
	
	@BeforeMethod
	public void preTestSetUp() {
		// set the app to home screen before start of any test case
//		Activity activity = new Activity("appPackage", "appActivity");
		//driver.startActivity(activity);
		
		// command to get package and activity of the current screen on android mobile device
		// adb shell dumpsys window | grep -E 'mCurrentFocus'  -- MAC
		// adb shell dumpsys window | find "mCurrentFocus" -- windows
	}
	
	@Test(dataProvider = "data")
	public void testCase1(String text,String value) {
		
//		pageObject1.setField(text);
//		
//		pageObject1.scrollToText(value);
//		
//		AssertJUnit.assertEquals(text, pageObject1.getField());
//		
//		PageObject2 pageObject2 =  pageObject1.submitForm();
//		
//		pageObject2.setField(2);
//		
//		pageObject2.getField(2);
//		
//		pageObject2.getLocator1().click();
		
		System.out.println("test case 1 device 1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testCase2() {
		System.out.println("test case 2 device 1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	
	@DataProvider
	public Object[][] data(){
		Object [][] dataSet = {{"Text1","Value1"},{"Text2","Value2"}};
		return dataSet;
	}

}
