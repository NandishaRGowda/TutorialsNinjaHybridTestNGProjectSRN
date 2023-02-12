package com.tutorialninja.qa.pagesfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	
	//objects
	@FindBy(linkText="My Account")
	private WebElement myAccountDropmenu;
	
	@FindBy(linkText="Login")
	private WebElement LoginOption;
	
	@FindBy(linkText="Register")
	WebElement RegisterOptions;
	
	@FindBy(name="search")
	WebElement SearchOption;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement searchButton;
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);//Homepage.class
		
	}
	//Actions
	public SearchPage ClickOnsearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}
	
	
	public void ClickOnsearchOption(String ProductName) {
		SearchOption.sendKeys(ProductName);
	}
	
	public SearchPage SearchProduct(String ProductName) {
		SearchOption.sendKeys(ProductName);
		searchButton.click();
		return new SearchPage(driver);
		
	}
	
	
	
	
	public void ClickOnMyAccount() {
		myAccountDropmenu.click();
		}
	public LoginPage SelectLoginOption() {
		LoginOption.click();
		return new LoginPage(driver);
		}
	public LoginPage navigateTOLoginPage() {
		myAccountDropmenu.click();
		LoginOption.click();
		return new LoginPage(driver);
	}
	
	
	public RegisterPage SelectRegisterOption() {
		RegisterOptions.click();
		return new RegisterPage(driver);
	}
	public LoginPage navigateToLoginpageThrougrigester() {
		myAccountDropmenu.click();
		RegisterOptions.click();
		return new LoginPage(driver);
	}
	
	
	
	
	
}
