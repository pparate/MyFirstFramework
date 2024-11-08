package appium.mobileFramework.pageObjects.ios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appium.mobileFramework.utils.AndroidActions;
import appium.mobileFramework.utils.IOSActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PageObject3 extends IOSActions {
	
	@iOSXCUITFindBy(id="")
	private WebElement locator1;
	
	@iOSXCUITFindBy(xpath="")
	private WebElement locator2;
	
	/**
	    * Priority of the searching. Higher number means lower priority.
	    *
	    * @return priority of the searching
	    */
	@iOSXCUITFindBy(priority=1)
	@iOSXCUITFindBy(accessibility="")
	private WebElement locator3;
	
	//IOS other locators
	//iOSClassChain
	//iOSNsPredicate
	//className
	//tagName
	
	IOSDriver driver;
	
	public PageObject3(IOSDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void setField(String text) {
		locator1.sendKeys(text);
		driver.hideKeyboard();
	}
	
	public String getField() {
		return locator1.getText();
	}
	


}
