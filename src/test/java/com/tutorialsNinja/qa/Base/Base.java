package com.tutorialsNinja.qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tutorialsNinjaUtilities.SrnUtilities;

public class Base {
	WebDriver driver;
	public Properties prop;
	public Properties TestDataProp;

	public Base() {
		  prop=new Properties();
		  File propFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\TutorialsNinja\\qa\\config\\config.properties");
			try{
				FileInputStream fis=new FileInputStream(propFile);
				prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
			TestDataProp=new Properties();
			File TestDataFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\TutorialsNinja\\qa\\TestData\\testdata.properties");
			try{
				FileInputStream TestdataFis=new FileInputStream(TestDataFile);
			TestDataProp.load(TestdataFis);
			}catch(Throwable e) {
				e.printStackTrace();
			}		
	}
	public WebDriver LanchBrowser(String browserName) {
	if(browserName.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
		
	}else if(browserName.equals("firefox")) {
		driver=new FirefoxDriver();
	}else if(browserName.equalsIgnoreCase("edge")) {
		driver=new EdgeDriver();
	}else if(browserName.equalsIgnoreCase("safari")) {
		driver=new SafariDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(SrnUtilities.IMLICT_WAIT));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(SrnUtilities.PAGE_LOAD_WAIT));
	driver.get(prop.getProperty("url"));
	return driver;
	
	}
}
