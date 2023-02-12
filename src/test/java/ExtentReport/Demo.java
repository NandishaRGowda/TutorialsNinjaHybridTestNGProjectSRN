package ExtentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Demo {
	public static void main(String[] args) throws IOException {
		ExtentReports extent=new ExtentReports();
		File file=new File(System.getProperty("user.dir")+"\\NandiExtentReporter\\eReport.html");
		ExtentSparkReporter SparkReporter =new ExtentSparkReporter(file);
		extent.attachReporter(SparkReporter);
		
		ExtentTest eTest1 = extent.createTest("NandiTest1");
		eTest1.log(Status.PASS, "TestCase1 Passed By nandi");
		//eTest1.pass("TestCase1 Passed By nandi");
		
		ExtentTest eTest2 = extent.createTest("NandiTest2");
		eTest2.log(Status.FAIL, "TestCase 2 failed By intentionaly");
		//eTest2.fail("TestCase 2 failed By intentionaly");
		
		ExtentTest eTest3 = extent.createTest("Nanditest3");
		eTest3.log(Status.SKIP, "TestCase3 is skipped by intentionally");
		//eTest3.skip("TestCase3 is skipped by intentionally");
		
		
		extent.flush();
		Desktop.getDesktop().browse(file.toURI()); 
	
	
	
	
	}
	
	

}
