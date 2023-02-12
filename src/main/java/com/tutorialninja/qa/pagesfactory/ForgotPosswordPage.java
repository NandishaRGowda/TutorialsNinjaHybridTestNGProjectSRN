package com.tutorialninja.qa.pagesfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPosswordPage {
	WebDriver driver;
	
	@FindBy(xpath="//h1[normalize-space()='Forgot Your Password?']")
	WebElement ForgotPossWordPageText;
	
	public ForgotPosswordPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String RetrieveForgotPosswordText() {
		String GetForgotPossWordPageText = ForgotPossWordPageText.getText();
		return GetForgotPossWordPageText;
	}
	
	
	
	
	
}
