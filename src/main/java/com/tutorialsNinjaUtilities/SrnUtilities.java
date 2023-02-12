package com.tutorialsNinjaUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class SrnUtilities {
	
	public static final int IMLICT_WAIT=10;
	public static final int PAGE_LOAD_WAIT=5; 
	
	public static String Timestamp(){
		Date date=new Date();
			String timestamp = date.toString().replace(" ", "_").replace(":", "_");
			return "nandishasrn"+timestamp+"@gmail.com";
		}
	public static Object[][] getTestDatafromExcel(String sheetName) {
		XSSFWorkbook workbook=null;
		File ExelFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\TutorialsNinja\\qa\\TestData\\TutorialsNinjaTestData.xlsx");
		try {
		FileInputStream fisExel=new FileInputStream(ExelFile);
		workbook=new XSSFWorkbook(fisExel);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();//number of rows
		int columns = sheet.getRow(0).getLastCellNum();//number of columns
		Object [][] data=new Object[rows][columns];
		
		for(int i=0; i<rows; i++) {
			XSSFRow row = sheet.getRow(i+1);
			
		for(int j=0; j<columns; j++) {
			XSSFCell cell = row.getCell(j);
			CellType celltype = cell.getCellType();
			
		
			switch(celltype){
			case STRING:
			data[i][j]=cell.getStringCellValue();
			break;
			
			case NUMERIC:
				data[i][j]=Integer.toString( (int)cell.getNumericCellValue());
		break;
		
			case BOOLEAN:
				data[i][j]=cell.getBooleanCellValue();
				break;
			}
			
		}
					
		}
	
		return data;
		
	}

		public static String captureScreenshot(WebDriver driver,String testName) {
			File srcScreenShot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String destinationScreenshotPath=System.getProperty("user.dir")+"\\ScreenShotSRN\\"+testName+".png";
			try {
				FileHandler.copy(srcScreenShot, new File(destinationScreenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return destinationScreenshotPath;
		}







}



