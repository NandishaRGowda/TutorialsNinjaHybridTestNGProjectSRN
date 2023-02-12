package com.tuturialsNinja.qa.Listenrs;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsNinjaUtilities.ExtentsReporterSRN;
import com.tutorialsNinjaUtilities.SrnUtilities;

public class MyListenrs implements ITestListener{
	ExtentReports extentsReporters;
	ExtentTest extentTest;
	String testName;

	
	@Override
	public void onStart(ITestContext context) {
		 extentsReporters = ExtentsReporterSRN.generateExtentReporter();
		
		
		//System.out.println("excution of the project is started");
	
	}
	@Override
	public void onTestStart(ITestResult result) {
		
		testName = result.getName();
		 extentTest = extentsReporters.createTest(testName);
		extentTest.log(Status.INFO, testName+" is started successfully");
		
		//System.out.println(testName+" is started successfully");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//String testName = result.getName();
		extentTest.log(Status.PASS, testName+" excuted successfully");
		
		//System.out.println(testName+" excuted successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//String testName = result.getName();
		//extentTest.log(Status.FAIL, testName+" got failed");
		
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			
			e.printStackTrace();
		}
		
		String destinationScreenshotPath = SrnUtilities.captureScreenshot(driver, testName);
		
		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName+" got failed");
		
		
		/*System.out.println(testName+" got failed");
	System.out.println(result.getThrowable());
	System.out.println("screenShot Taken");*/
	} 

	@Override
	public void onTestSkipped(ITestResult result) {
		//String testName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName+"got skipped");
		
		
		/*System.out.println(testName+" got skipped");
	System.out.println(result.getThrowable());*/
	}

	
	@Override
	public void onFinish(ITestContext context) {
		extentsReporters.flush();
		//System.out.println(" Fineshed and excuted all testcase successfully");
		
		String pathOFExtentReport=System.getProperty("user.dir")+"\\test-output\\NandiExtentReports\\ExtentReport.html";
		File extentReportFile=new File(pathOFExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReportFile.toURI());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
