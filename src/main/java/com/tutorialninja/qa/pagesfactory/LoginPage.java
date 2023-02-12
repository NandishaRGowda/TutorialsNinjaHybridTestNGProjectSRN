package com.tutorialninja.qa.pagesfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(id="input-email")
	private WebElement EmailAdressField;
	
	@FindBy(id="input-password")
	private  WebElement Passwordfield;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement LoginButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement EmailAndPasswordWarningMessage;
	
	@FindBy(linkText="Forgotten Password")
	WebElement ForgotPosswordLink;
	
	@FindBy(xpath="//h2[normalize-space()='New Customer']")
	WebElement NewCustomer;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	public String LoginpageText() {
		String NewCustomerText = NewCustomer.getText();
		return NewCustomerText;
	}
	
	public void ClickOnForgotPosswordLink() {
		ForgotPosswordLink.click();
	}
	
	public void enterEmailAdress(String emailText) {
		EmailAdressField.sendKeys(emailText);
	}
	public void enterPassword(String Password) {
		Passwordfield.sendKeys(Password);
		}
	public AccountPage clickOnLoginButton() {
		LoginButton.click();
		return new AccountPage(driver);
	}
	public AccountPage Login(String emailText, String passwordd ) {
		EmailAdressField.sendKeys(emailText);
		Passwordfield.sendKeys(passwordd);
		LoginButton.click();
		return new AccountPage(driver);
	}
	
	
	public String EmailPaswordWarningMessage() {
		String warningText = EmailAndPasswordWarningMessage.getText();
		return warningText;
	}
}
