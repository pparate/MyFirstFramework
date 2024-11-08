package appium.mobileFramework.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appium.mobileFramework.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageObject1 extends AndroidActions {
	
	@AndroidFindBy(id="")
	private WebElement locator1;
	
	@AndroidFindBy(xpath="")
	private WebElement locator2;
	
	/**
	    * Priority of the searching. Higher number means lower priority.
	    *
	    * @return priority of the searching
	    */
	@AndroidFindBy(priority=1)
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().text(\"text\"))")
	private WebElement element;

	//Android other locators
	//accessibility
	//className
	//tagName

	
	AndroidDriver driver;
	
	public PageObject1(AndroidDriver driver) {
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
	
	public PageObject2 submitForm() {
		locator2.click();
		return new PageObject2(driver);
		
	}


}
