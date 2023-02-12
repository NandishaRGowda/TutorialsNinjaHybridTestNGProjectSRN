package com.tutorialninja.qa.pagesfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;
	@FindBy(linkText="Change your password")
	WebElement changeYourpasswordOption;
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement MyAccountOption;
	
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String retrieveMyACCOUNTtext() {
		String MyAccountOptionText = MyAccountOption.getText();
		return MyAccountOptionText;
	}
	
	
	
	public boolean getChangeYourpasswordInformation() {
		boolean displaystatus = changeYourpasswordOption.isDisplayed();
		return displaystatus;
		
	}
	
	
}


