package com.tutorialsNinjaTestcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.pagesfactory.AccountSuccessPage;
import com.tutorialninja.qa.pagesfactory.Homepage;
import com.tutorialninja.qa.pagesfactory.RegisterPage;
import com.tutorialsNinja.qa.Base.Base;
import com.tutorialsNinjaUtilities.SrnUtilities;

//update
public class RegisterTest extends Base {
	
	public WebDriver driver;
	RegisterPage rigesterpage;
	
	public RegisterTest() {
		super();
	}
	
	
    @AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
@BeforeMethod
public void setup() {
	driver=LanchBrowser(prop.getProperty("browserName"));
	Homepage homepage=new Homepage(driver);
	homepage.ClickOnMyAccount();
	 rigesterpage = homepage.SelectRegisterOption();
	
	/*driver.findElement(By.linkText("My Account")).click();
	driver.findElement(By.linkText("Register")).click();*/
}

@Test(priority=1)
	public void RegisterwithMandotoryFields() {
		
	AccountSuccessPage accountSucesspage=rigesterpage.RigesterWith(TestDataProp.getProperty("FirstName"), TestDataProp.getProperty("LastName"), SrnUtilities.Timestamp(), TestDataProp.getProperty("Telephone"), prop.getProperty("ValidPassword"), prop.getProperty("ValidPassword"));
	Assert.assertEquals(accountSucesspage.RetrieveAccountSuccesspageText(), TestDataProp.getProperty("AccountCreatedWarningMessage"));
	
	/*rigesterpage.EnterFirstname(TestDataProp.getProperty("FirstName"));
		rigesterpage.Enterlastname(TestDataProp.getProperty("LastName"));
		rigesterpage.EnterEmailAdress(SrnUtilities.Timestamp());
		rigesterpage.EnterTelephoneNumber(TestDataProp.getProperty("Telephone"));
		rigesterpage.EnterPossword(prop.getProperty("ValidPassword"));
		rigesterpage.EnterConfirmPossword(prop.getProperty("ValidPassword"));
	
		rigesterpage.ClickOnPrivacyPolicyField();
		rigesterpage.ClickOnContinueButton();
		
		AccountSuccessPage accountSucesspage=new AccountSuccessPage(driver);
		String actualResult = accountSucesspage.RetrieveAccountSuccesspageText();
		Assert.assertEquals(accountSucesspage.RetrieveAccountSuccesspageText(), TestDataProp.getProperty("AccountCreatedWarningMessage"));
	*/}
	
	
	
	
	
		/*driver.findElement(By.id("input-firstname")).sendKeys(TestDataProp.getProperty("FirstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(TestDataProp.getProperty("LastName"));
		driver.findElement(By.id("input-email")).sendKeys(SrnUtilities.Timestamp());
		driver.findElement(By.id("input-telephone")).sendKeys(TestDataProp.getProperty("Telephone"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("ValidPassword"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		 String actualResult = driver.findElement(By.xpath("//div[@class='col-sm-9']/h1")).getText();
		Assert.assertEquals(actualResult ,TestDataProp.getProperty("AccountCreatedWarningMessage") ," Nandi referance info =Account is not created by providing mondatory fields");
	}*/

  @Test(priority=2)
    public void RegisterWithAllTheFields() {
	 
	  rigesterpage.EnterFirstname(TestDataProp.getProperty("FirstName"));
	  rigesterpage.Enterlastname(TestDataProp.getProperty("LastName"));
		rigesterpage.EnterEmailAdress(SrnUtilities.Timestamp());
		rigesterpage.EnterTelephoneNumber(TestDataProp.getProperty("Telephone"));
		rigesterpage.EnterPossword(prop.getProperty("ValidPassword"));
		rigesterpage.EnterConfirmPossword(prop.getProperty("ValidPassword"));
		rigesterpage.SelectNewsLetterRadioOption();
		rigesterpage.ClickOnPrivacyPolicyField();
		rigesterpage.ClickOnContinueButton();
		
		AccountSuccessPage accountSucesspage=new AccountSuccessPage(driver);
		String actualResult = accountSucesspage.RetrieveAccountSuccesspageText();
		Assert.assertEquals(actualResult, TestDataProp.getProperty("AccountCreatedWarningMessage"));
	  
	  
	  
	  
    	/*driver.findElement(By.id("input-firstname")).sendKeys(TestDataProp.getProperty("FirstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(TestDataProp.getProperty("LastName"));
		driver.findElement(By.id("input-email")).sendKeys(SrnUtilities.Timestamp());
		driver.findElement(By.id("input-telephone")).sendKeys(TestDataProp.getProperty("Telephone"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("ValidPassword"));
		driver.findElement(By.name("newsletter")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		 String actualResult = driver.findElement(By.xpath("//div[@class='col-sm-9']/h1")).getText();
		Assert.assertEquals(actualResult ,TestDataProp.getProperty("AccountCreatedWarningMessage"),"Account is not created by providing mondatory fields");
	*/}
  @Test(priority=3)
  public void RegisterWithDuplicateEmailAdress() {
	    
	
	  rigesterpage.EnterFirstname(TestDataProp.getProperty("FirstName"));
	  rigesterpage.Enterlastname(TestDataProp.getProperty("LastName"));
	  rigesterpage.EnterEmailAdress(prop.getProperty("ValidEmail"));
	  rigesterpage.EnterTelephoneNumber(TestDataProp.getProperty("Telephone"));
		rigesterpage.EnterPossword(prop.getProperty("ValidPassword"));
		rigesterpage.EnterConfirmPossword(prop.getProperty("ValidPassword"));
		rigesterpage.SelectNewsLetterRadioOption();
		rigesterpage.ClickOnPrivacyPolicyField();
		rigesterpage.ClickOnContinueButton();
		String ar=rigesterpage.WarningMSgforAlreadyRegisterEmail();
	  Assert.assertEquals(ar, TestDataProp.getProperty("AlreadyRegisterWarningMesssage"));
	  
	  
	  
	  
	  
	 /* driver.findElement(By.id("input-firstname")).sendKeys(TestDataProp.getProperty("FirstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(TestDataProp.getProperty("LastName"));
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("ValidEmail"));
		driver.findElement(By.id("input-telephone")).sendKeys(TestDataProp.getProperty("Telephone"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("ValidPassword"));
		driver.findElement(By.name("newsletter")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		String ar = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertEquals(ar, TestDataProp.getProperty("AlreadyRegisterWarningMesssage"));
		
  */}        @Test(priority=4)
        public void RegisterWithoutCredentials()  {
	
	  rigesterpage.ClickOnContinueButton();
	  Assert.assertTrue(rigesterpage.WarningMessageStatus(TestDataProp.getProperty("FirstNameTextFieldWarningMessage"), TestDataProp.getProperty("LastNameTextFieldWarningMessage"), TestDataProp.getProperty("EmailAdressFieldWarningMessage"), TestDataProp.getProperty("TelephonefieldWarningMessage"), TestDataProp.getProperty("PasswordFieldwarningMessage"),TestDataProp.getProperty("PrivacyPolicywarningMessage")));
	 
	  
	  /* String ActualPrivacyFieldWarningMessage = rigesterpage.PrivacyFieldWarningMesssage();
	  Assert.assertEquals(ActualPrivacyFieldWarningMessage, TestDataProp.getProperty("PrivacyPolicywarningMessage"));
	 
	  String FirstNameFieldWarningMessageText = rigesterpage.FirstNameFieldWarningMessage();
	  Assert.assertEquals(FirstNameFieldWarningMessageText, TestDataProp.getProperty("FirstNameTextFieldWarningMessage"));
	  
	  String LastNamefieldWarningText = rigesterpage.LastnameFieldwarningMessage();
	 Assert.assertEquals(LastNamefieldWarningText, TestDataProp.getProperty("LastNameTextFieldWarningMessage"));
	 
	 String EmailAdressWarningMsgText = rigesterpage.EmailAdressWarningMsg();
	 Assert.assertEquals(EmailAdressWarningMsgText, TestDataProp.getProperty("EmailAdressFieldWarningMessage"));
	 
	 String TelephoneFieldwarningMessgaeText = rigesterpage.TelephoneFieldwarningMessgae();
	  Assert.assertEquals(TelephoneFieldwarningMessgaeText, TestDataProp.getProperty("TelephonefieldWarningMessage"));
	  
	  String PasswordFieldWarningMessage = rigesterpage.PasswordFieldWarningMessage();
	  Assert.assertEquals(PasswordFieldWarningMessage, TestDataProp.getProperty("PasswordFieldwarningMessage"));
	  
        	/*driver.findElement(By.id("input-firstname")).sendKeys("");
     		driver.findElement(By.id("input-lastname")).sendKeys("");
     		driver.findElement(By.id("input-email")).sendKeys("");
     		driver.findElement(By.id("input-telephone")).sendKeys("");
     		driver.findElement(By.id("input-password")).sendKeys("");
     		driver.findElement(By.id("input-confirm")).sendKeys("");
     		//driver.findElement(By.name("newsletter")).click();
     		driver.findElement(By.name("agree")).click();
     		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
     		Thread.sleep(3000);
     		
     		String FirstNameWarningMsg = driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText();
     	    Assert.assertEquals(FirstNameWarningMsg, TestDataProp.getProperty("FirstNameTextFieldWarningMessage"));
     	    
     	   String lastnameWarningMSG = driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText();
     	   Assert.assertEquals(lastnameWarningMSG, TestDataProp.getProperty("LastNameTextFieldWarningMessage"));
     	    
     	    
     		String EmailAdressWarningMsg = driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText();
     	  Assert.assertEquals(EmailAdressWarningMsg, TestDataProp.getProperty("EmailAdressFieldWarningMessage"));
     	
     	  String TelephoneFieldWarningMsg = driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText();
        Assert.assertEquals(TelephoneFieldWarningMsg, TestDataProp.getProperty(TelephoneFieldWarningMsg));*/
  }
  @Test(priority=5)
  public void VerifyRegisteringWithYesOption() {
	  
	
	  rigesterpage.EnterFirstname(TestDataProp.getProperty("FirstName"));
	  rigesterpage.Enterlastname(TestDataProp.getProperty("LastName"));
	  rigesterpage.EnterEmailAdress(SrnUtilities.Timestamp());
	  rigesterpage.EnterTelephoneNumber(TestDataProp.getProperty("Telephone"));
	  rigesterpage.EnterPossword(prop.getProperty("ValidPassword"));
	  rigesterpage.EnterConfirmPossword(prop.getProperty("ValidPassword"));
	  rigesterpage.SelectNewsLetterRadioOption();
	  rigesterpage.ClickOnPrivacyPolicyField();
	  rigesterpage.ClickOnContinueButton();
	  AccountSuccessPage accountSucesspage=new AccountSuccessPage(driver);
		String actualResult = accountSucesspage.RetrieveAccountSuccesspageText();
		Assert.assertEquals(actualResult, TestDataProp.getProperty("AccountCreatedWarningMessage"));
  }
  
  /*RegisterPage rigesterpage=new RegisterPage(driver);
  rigesterpage.EnterFirstname(TestDataProp.getProperty("FirstName"));
  rigesterpage.Enterlastname(TestDataProp.getProperty("LastName"));
	rigesterpage.EnterEmailAdress(SrnUtilities.Timestamp());
	rigesterpage.EnterTelephoneNumber(TestDataProp.getProperty("Telephone"));
	rigesterpage.EnterPossword(prop.getProperty("ValidPassword"));
	rigesterpage.EnterConfirmPossword(prop.getProperty("ValidPassword"));
	rigesterpage.SelectNewsLetterRadioOption();
	rigesterpage.ClickOnPrivacyPolicyField();
	rigesterpage.ClickOnContinueButton();
	
	AccountSuccessPage accountSucesspage=new AccountSuccessPage(driver);
	String actualResult = accountSucesspage.RetrieveAccountSuccesspageText();
	Assert.assertEquals(actualResult, TestDataProp.getProperty("AccountCreatedWarningMessage"));*/
  
  
  
  
  
  
  
  	
  }






















