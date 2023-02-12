package com.tutorialninja.qa.pagesfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	@FindBy(linkText="Apple Cinema 30\"")
	WebElement validproducteDisplyed;
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
	WebElement InvalidProduct;
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	public boolean retrieveInvalidProduct() {
		boolean displayStatus = InvalidProduct.isDisplayed();
		return displayStatus;
	}
	
	
	public boolean RetriveValidProduct() {
	boolean validproducteDisplyedStatus = validproducteDisplyed.isDisplayed();
		return validproducteDisplyedStatus;
		
	}
}
