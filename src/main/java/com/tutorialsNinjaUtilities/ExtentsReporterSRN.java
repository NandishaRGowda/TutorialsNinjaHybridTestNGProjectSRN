package com.tutorialsNinjaUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentsReporterSRN {
	public static ExtentReports generateExtentReporter() {
		
		ExtentReports extentReport=new ExtentReports();
		
		File file=new File(System.getProperty("user.dir")+"\\test-output\\NandiExtentReports\\ExtentReport.html");
		ExtentSparkReporter SparkReporter=new ExtentSparkReporter(file);
		
		SparkReporter.config().setTheme(Theme.DARK);
		SparkReporter.config().setReportName("TutorialsNinjaExtendreportSRN");
		SparkReporter.config().setDocumentTitle("SRNextendReportforTN");
		SparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(SparkReporter);
		
		Properties prop=new Properties();
		File configFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\TutorialsNinja\\qa\\config\\config.properties");
		try {
		FileInputStream FISconfigProp=new FileInputStream(configFile);
		prop.load(FISconfigProp);
		}catch (Throwable t) {
			t.printStackTrace();
		}
		
		extentReport.setSystemInfo("Application URL", prop.getProperty("url"));
		extentReport.setSystemInfo("BrowserNameSRN", prop.getProperty("browserName"));
		extentReport.setSystemInfo("Email adress", prop.getProperty("ValidEmail"));
		extentReport.setSystemInfo("validpassword", prop.getProperty("ValidPassword"));
		extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.version"));
		extentReport.setSystemInfo("javaVersion", System.getProperty("java.version"));
		
		return extentReport;
	}		
}
