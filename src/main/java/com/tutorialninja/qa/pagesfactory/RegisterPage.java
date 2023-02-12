package com.tutorialninja.qa.pagesfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	@FindBy(id="input-firstname")
	private WebElement FirstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement LastnameField;
	
	@FindBy(id="input-email")
	private WebElement EmailtextField;
	
	@FindBy(id="input-telephone")
	private WebElement TelephoneField;
	
	@FindBy(id="input-password")
	private WebElement PasswordField;
	
	@FindBy(id="input-confirm")
	private WebElement ConfirmPasswordFiels;
	
	@FindBy(name="agree")
	private WebElement PrivacyPolicyCheckBoxFiels;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement ContinueButton;
	
	@FindBy(name="newsletter")
	private WebElement NewsLetterOption;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement WarningAlreadyRegisterEmail;
	
	@FindBy(name="newsletter")
	WebElement YesRadioOptions;
	
	
	@FindBy(linkText="login page")
	WebElement LoginPageOption;
	
	


	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyPolicywarning;
	
	@FindBy(xpath="//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement FirstNameFieldWarning;
	
	@FindBy(xpath="//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement LastNamefieldWarning;
	
	@FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	WebElement EmailAdresswarning;
	
	@FindBy(xpath="//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement TelephoneFieldwarning;
	
	@FindBy(xpath="//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement Invalidpasswordwarning;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	public LoginPage ClickOnLoginOptionInRigesterPage() {
		LoginPageOption.click();
		return new LoginPage(driver);
	}
	
	
	
	public void ClickOnYesRadioOptions() {
		YesRadioOptions.click();
	}
	
	public void EnterFirstname(String FirstnameText) {
		FirstNameField.sendKeys(FirstnameText);
		}
	public void Enterlastname(String LastnameText) {
		LastnameField.sendKeys(LastnameText);
		}
	public void EnterEmailAdress(String EmailText) {
		EmailtextField.sendKeys(EmailText);
	}
	public void EnterTelephoneNumber(String TelephoneNumber) {
		TelephoneField.sendKeys(TelephoneNumber);
	}
	public void EnterPossword(String passwordText) {
	PasswordField.sendKeys(passwordText);
}
	public void EnterConfirmPossword(String ConfirmPosswordText) {
		ConfirmPasswordFiels.sendKeys(ConfirmPosswordText);
	}
	public void ClickOnPrivacyPolicyField() {
		PrivacyPolicyCheckBoxFiels.click();
	}
	public AccountSuccessPage ClickOnContinueButton() {
		ContinueButton.click();
		return new AccountSuccessPage(driver);
	}
	public void SelectNewsLetterRadioOption() {
		NewsLetterOption.click();
	}

	public String FirstNameFieldWarningMessage() {
		String FirstNameFieldWarningText = FirstNameFieldWarning.getText();
		return FirstNameFieldWarningText;
	}
		
	public String LastnameFieldwarningMessage() {
		String LastNamefieldWarningText = LastNamefieldWarning.getText();
		return LastNamefieldWarningText;
	}
	public String EmailAdressWarningMsg() {
		String EmailAdressWarningMsgText = EmailAdresswarning.getText();
		return EmailAdressWarningMsgText;
	}

	public String TelephoneFieldwarningMessgae() {
		String TelephoneFieldwarningText = TelephoneFieldwarning.getText();
		return TelephoneFieldwarningText;
	}
	
	public String PasswordFieldWarningMessage() {
		String InvalidpasswordwarningText = Invalidpasswordwarning.getText();
		return InvalidpasswordwarningText;
	}
	public String PrivacyFieldWarningMesssage() {
		String privacyPolicywarningText = privacyPolicywarning.getText();
		return privacyPolicywarningText;
	}
	
	public String WarningMSgforAlreadyRegisterEmail() {
		String warningtext = WarningAlreadyRegisterEmail.getText();
		return warningtext;
	}
	
	
	
	
	public AccountSuccessPage RigesterWith(String FirstnameText,String LastnameText,String EmailText,String TelephoneNumber,String passwordText,String ConfirmPosswordText ) {
		FirstNameField.sendKeys(FirstnameText);
		LastnameField.sendKeys(LastnameText);
		EmailtextField.sendKeys(EmailText);
		TelephoneField.sendKeys(TelephoneNumber);
		PasswordField.sendKeys(passwordText);
		ConfirmPasswordFiels.sendKeys(ConfirmPosswordText);
		NewsLetterOption.click();
		PrivacyPolicyCheckBoxFiels.click();
		ContinueButton.click();
		return new AccountSuccessPage(driver);

	}
	
	public boolean WarningMessageStatus(String ExpectedFirstNameFieldWarningText,String ExpectedLastNamefieldWarningText , String ExpectedEmailAdressWarningMsgText,String ExpectedTelephoneFieldwarningText,String ExpectedInvalidpasswordwarningText,String ExpectedPrivacyPolicywarningText) {
	
		//String ActualFirstNameFieldWarningText = FirstNameFieldWarning.getText();
		boolean FirstnamefieldWarning = FirstNameFieldWarning.getText().equals(ExpectedFirstNameFieldWarningText);
	
		//String ActualLastNamefieldWarningText = LastNamefieldWarning.getText();
		boolean LastNameWarning = LastNamefieldWarning.getText().equals(ExpectedLastNamefieldWarningText);
	
		//String ActualEmailAdressWarningMsgText = EmailAdresswarning.getText();
		boolean EmailWarning = EmailAdresswarning.getText().equals(ExpectedEmailAdressWarningMsgText);
	 
		//String ActualTelephoneFieldwarningText = TelephoneFieldwarning.getText();
		boolean TelephonefieldWarning =TelephoneFieldwarning.getText().equals(ExpectedTelephoneFieldwarningText);
	 
		//String ActualInvalidpasswordwarningText = Invalidpasswordwarning.getText();
		boolean PasswordWarning = Invalidpasswordwarning.getText().equals(ExpectedInvalidpasswordwarningText);
	
		//String AcutalprivacyPolicywarningText = privacyPolicywarning.getText();
		boolean PrivacypolicyWarning = privacyPolicywarning.getText().equals(ExpectedPrivacyPolicywarningText);
		
		return FirstnamefieldWarning && LastNameWarning && EmailWarning && TelephonefieldWarning && PasswordWarning && PrivacypolicyWarning  ;

		
	}
	
	
	
	
	
	
}