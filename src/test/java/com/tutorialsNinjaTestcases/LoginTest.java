package com.tutorialsNinjaTestcases;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialninja.qa.pagesfactory.AccountPage;
import com.tutorialninja.qa.pagesfactory.ForgotPosswordPage;
import com.tutorialninja.qa.pagesfactory.Homepage;
import com.tutorialninja.qa.pagesfactory.LoginPage;
import com.tutorialninja.qa.pagesfactory.RegisterPage;
import com.tutorialsNinja.qa.Base.Base;
import com.tutorialsNinjaUtilities.SrnUtilities;
public class LoginTest extends Base {
	public LoginTest() {
		super();
	}
	public WebDriver driver;
	LoginPage loginPage;
	RegisterPage register;
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@BeforeMethod
	public void SetUp() { 
		
		driver=LanchBrowser(prop.getProperty("browserName"));
		//hardcoded
		Homepage homepage=new Homepage(driver);
		homepage.navigateToLoginpageThrougrigester();
		
		loginPage=homepage.navigateTOLoginPage();
		/*homepage.ClickOnMyAccount();
		 loginPage = homepage.SelectLoginOption();
		
		//old
		/*driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();*/ 
	
	}
	
	@Test(priority=1,dataProvider="ValidCredentialsSupplier",dependsOnMethods= {"LoginWithInvalidCredentials","LoginWithInvalidEmailandvalidpassword"})
	public void LoginWithValidCredentials(String email,String Password) { 
		
	AccountPage accountPage = loginPage.Login(email, Password);
	Assert.assertTrue(accountPage.getChangeYourpasswordInformation());
	
		/*loginPage.enterEmailAdress(email);
		loginPage.enterPassword(Password);
		AccountPage accountPage = loginPage.clickOnLoginButton();
		
		//AccountPage accountpage=new AccountPage(driver);
	Assert.assertTrue(accountPage.getChangeYourpasswordInformation());
	
		
		/*driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Change your password")).isDisplayed());*/
		
	}
	
	@DataProvider(name="ValidCredentialsSupplier")
	
	/*public Object[][] supplyTestData(){
		Object[] [] data= {{"nandi1@gmail.com", "123456"} ,
				{"nandi2@gmail.com", "123456"} ,
				{"nandi1@gmail.com", "123456"}};
		return data;*/
	
	
		public Object[][] supplyTestData(){                           //data taken from exel
		Object[][] data=SrnUtilities.getTestDatafromExcel("Login");
		return data;
	}
		
	@Test(priority=2)
	public void LoginWithInvalidCredentials()   {
		
		
		loginPage.enterEmailAdress(SrnUtilities.Timestamp());
		loginPage.enterPassword(TestDataProp.getProperty("InValidPassword"));
		loginPage.clickOnLoginButton();
		
		String ActualWarningMsg=loginPage.EmailPaswordWarningMessage();
		String ExpectedwarningMSg=TestDataProp.getProperty("EmailAndPasswordWarningMsg");
		Assert.assertTrue(ActualWarningMsg.contains(ExpectedwarningMSg));
		
		
		
		/*driver.findElement(By.id("input-email")).sendKeys("nandha"+SrnUtilities.Timestamp()+"@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys(TestDataProp.getProperty("InValidPassword"));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());*/
		
		}
	@Test(priority=3)
	public void LoginWithInvalidEmailandvalidpassword() throws InterruptedException  {
		
		loginPage.Login(SrnUtilities.Timestamp(), prop.getProperty("ValidPassword"));
		Assert.assertEquals(loginPage.EmailPaswordWarningMessage(), TestDataProp.getProperty("EmailAndPasswordWarningMsg"));
		
		/*loginPage.enterEmailAdress(SrnUtilities.Timestamp());
		loginPage.enterPassword(prop.getProperty("ValidPassword"));
		loginPage.clickOnLoginButton();
		
		String ActualWarningMsg=loginPage.EmailPaswordWarningMessage();
		String ExpectedwarningMSg=TestDataProp.getProperty("EmailAndPasswordWarningMsg");
		Assert.assertTrue(ActualWarningMsg.contains(ExpectedwarningMSg));
		
		
		
		/*driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("nandha"+SrnUtilities.Timestamp()+"@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
	*/}
	
@Test(priority=4)
	public void LoginWithValidEmailAndInvalidPossword()  {
	
	loginPage.Login(prop.getProperty("ValidEmail"), TestDataProp.getProperty("InValidPassword"));
	
	/*loginPage.enterEmailAdress(prop.getProperty("ValidEmail"));
	loginPage.enterPassword(TestDataProp.getProperty("InValidPassword"));
	loginPage.clickOnLoginButton();*/
	
	String ActualWarningMsg=loginPage.EmailPaswordWarningMessage();
	String ExpectedwarningMSg=TestDataProp.getProperty("EmailAndPasswordWarningMsg");
	Assert.assertTrue(ActualWarningMsg.contains(ExpectedwarningMSg));
	
			/*driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("ValidEmail"));
		driver.findElement(By.id("input-password")).sendKeys("123456"+SrnUtilities.Timestamp());
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
	
	*/}
	
@Test(priority=5)
	public void LoginWithoutAnyCredentials() {  
	
	
	loginPage.clickOnLoginButton();
	String ActualWarningMsg=loginPage.EmailPaswordWarningMessage();
	String ExpectedwarningMSg=TestDataProp.getProperty("EmailAndPasswordWarningMsg");
	Assert.assertTrue(ActualWarningMsg.contains(ExpectedwarningMSg));
	
	
		/*driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
	*/}

@Test(priority=6)
public void VerifyForgotPosswordLink() {
	
	loginPage.ClickOnForgotPosswordLink();
	
	ForgotPosswordPage forgotPasswordPage=new ForgotPosswordPage(driver);
	String forgotPasswordPageText = forgotPasswordPage.RetrieveForgotPosswordText();
	Assert.assertEquals(forgotPasswordPageText, TestDataProp.getProperty("ForgotPosswordPageText"));
	
	/*driver.findElement(By.linkText("Forgotten Password")).click();
	Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Forgot Your Password?']")).isDisplayed());	
}
@Test(priority=7)
public void VerifyLoginingAndBrowserback() throws InterruptedException {
	LoginPage loginPage=new LoginPage(driver);
	loginPage.enterEmailAdress(TestDataProp.getProperty("ValidEmail"));
	loginPage.enterPassword(TestDataProp.getProperty("ValidPassword"));
	loginPage.clickOnLoginButton();
	driver.navigate().back();
	Thread.sleep(4000);
	String loginPagetext = loginPage.LoginpageText();
	Assert.assertEquals(loginPagetext, TestDataProp.getProperty("LoginPageText"));
	
	/*driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("ValidEmail"));
	driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
	driver.findElement(By.xpath("//input[@value='Login']")).click();
	
	driver.navigate().back();
	*/
}
	@Test(priority=7)
	public void VerifyLoginWithNavigateToDifferentPage() throws InterruptedException {
		RegisterPage register = new RegisterPage(driver);
		loginPage=register.ClickOnLoginOptionInRigesterPage();
		AccountPage accountPage = loginPage.Login(prop.getProperty("ValidEmail"), prop.getProperty("ValidPassword"));
		Thread.sleep(3000);
		Assert.assertEquals(accountPage.retrieveMyACCOUNTtext(), TestDataProp.getProperty("AccountPageHeadingDisplayStatus"));
		}





}

    
		

