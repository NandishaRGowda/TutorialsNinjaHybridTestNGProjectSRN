package com.tutorialsNinjaTestcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.pagesfactory.Homepage;
import com.tutorialninja.qa.pagesfactory.SearchPage;
import com.tutorialsNinja.qa.Base.Base;

public class SearchTest extends Base {
	
	public WebDriver driver;
	SearchPage searchpage;
	Homepage homepage ;
	
	public SearchTest() {
		super();
	}
	
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	@BeforeMethod
	public void setup() {
		driver=LanchBrowser(prop.getProperty("browserName"));
		 homepage =new Homepage(driver);
	}
	@Test(priority=1)
	public void VerifySearchWithValidProduct() {
		
		searchpage=homepage.SearchProduct(TestDataProp.getProperty("ProductName"));
		Assert.assertTrue(searchpage.RetriveValidProduct());
		
		/*Homepage homepage =new Homepage(driver);
		homepage.ClickOnsearchOption(TestDataProp.getProperty("ProductName"));
		 searchpage = homepage.ClickOnsearchButton();
		//SearchPage searchpage=new SearchPage(driver);
		Assert.assertTrue(searchpage.RetriveValidProduct());
		
		/*driver.findElement(By.name("search")).sendKeys(TestDataProp.getProperty("ProductName"));
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		String actualResult = driver.findElement(By.linkText("Apple Cinema 30\"")).getText();
		Assert.assertEquals(actualResult, "Apple Cinema 30\"");
		//Assert.assertTrue(driver.findElement(By.linkText("Apple Cinema 30\"")).isDisplayed());
		driver.quit();
	*/}
	
	
		
	
	
	
	
	
	
	
	
	
	@Test(priority=2)
	public void VerifySearchWithInvalidproduct() {
		
		searchpage=homepage.SearchProduct(TestDataProp.getProperty("InvalidProductName"));
		Assert.assertTrue(searchpage.retrieveInvalidProduct());
		
		/*Homepage homepage =new Homepage(driver);
		homepage.ClickOnsearchOption(TestDataProp.getProperty("InvalidProductName"));
		searchpage=homepage.ClickOnsearchButton();
		
		Assert.assertTrue(searchpage.retrieveInvalidProduct());
		
		
		/*driver.findElement(By.name("search")).sendKeys(TestDataProp.getProperty("InvalidProductName"));
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criteria')]")).isDisplayed());
		driver.quit();
	*/}
	@Test(priority=3)
	public void VerifySearchWithoutAnyProduct() {
		
		searchpage=homepage.SearchProduct("");
		Assert.assertTrue(searchpage.retrieveInvalidProduct());
		
		/*Homepage homepage =new Homepage(driver);
		searchpage=homepage.ClickOnsearchButton();
		
		Assert.assertTrue(searchpage.retrieveInvalidProduct());
		
		/*driver.findElement(By.name("search")).sendKeys("");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criteria')]")).isDisplayed());

		*/
		
	}
		
}
