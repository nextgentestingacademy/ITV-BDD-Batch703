package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import utils.LoggerUtils;

public class HomePage extends BaseClass {
	// page specific locators
	@FindBy(xpath = "//div[@class='dds-w-7 dds-h-7 dds-flex dds-items-center dds-cursor-pointer']//*[name()='svg']")
	WebElement imgSearch;

	@FindBy(xpath = "//div[@class='dds-w-8 dds-h-8 dds-flex dds-items-center dds-justify-center']//*[name()='svg']")
	WebElement imgLocation;

	public HomePage() {
		super();
		PageFactory.initElements(driver, this);
	}

	// page specific methods
	public void clickSearch() {
		elementClick(imgSearch);
		LoggerUtils.info("Clicked on Search icon");
	}

	public void clickLocation() {
		elementClick(imgLocation);
		LoggerUtils.info("Clicked on Location icon");
	}
}