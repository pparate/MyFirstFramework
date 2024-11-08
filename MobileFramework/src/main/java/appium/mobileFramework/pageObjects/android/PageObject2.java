package appium.mobileFramework.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appium.mobileFramework.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageObject2 extends AndroidActions {
	
	@AndroidFindBy(id="")
	private WebElement locator1;
	
	// driver.findElements()
	@AndroidFindBy(xpath="")
	private List<WebElement> locator2;
	
	@AndroidFindBy(id="")
	private WebElement locator3;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().text(\"text\"))")
	private WebElement element;

	
	AndroidDriver driver;
	
	public PageObject2(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void setField(int index) {
		locator2.get(index).click();
		
	}
	
	public String getField(int index) {
		return locator2.get(index).getText();
	}
	
	public WebElement getLocator1() {
		return locator1;
	}
	
	public void selectDropdown() {
		locator3.click();
		scrollToText("dropdownValue").click();
		
		//element.click();
		
	}

}
