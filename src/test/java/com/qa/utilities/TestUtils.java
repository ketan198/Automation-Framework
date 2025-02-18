/**
 * 
 */
package com.qa.utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.qa.DriverUtilities.DriverManagerUtility;
import com.qa.base.TestBase;
import com.qa.constants.FrameworkConstants;
import com.qa.enums.ConfigPropertiesEnums;
import com.qa.enums.TestConstants;
import com.qa.reportutil.ExtentLogger;
import com.qa.reportutil.ReportManager;

/**
 * @author Ketan Tiwari
 *
 */
public class TestUtils extends TestBase {
	

	
	
	public static void verifyLink(String url) {
		
		try {
		URL link = new URL(url);
		HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
		httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
		httpURLConnection.connect();


		if (httpURLConnection.getResponseCode() == 200) {
		System.out.println(url + " - " + httpURLConnection.getResponseMessage());
		ExtentLogger.info(url+" - "+httpURLConnection.getResponseMessage() , false);
//		test.log(Status.INFO, url + " - " + httpURLConnection.getResponseMessage());
		} else if(httpURLConnection.getResponseCode()== 301) {
		System.out.println(url + " - " + httpURLConnection.getResponseMessage() );
		ExtentLogger.info(url+" - "+httpURLConnection.getResponseMessage() , false);
		}
		else {
			System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
//			test.log(Status.INFO, url + " - " + httpURLConnection.getResponseMessage()+ " - " + "is a broken link");
			ExtentLogger.info(url+" - "+httpURLConnection.getResponseMessage() +"-"+"is a broken link"  , false);
		}
		} catch (Exception e) {
		System.out.println(url + " - " + "is a broken link");
		ExtentLogger.info(url+" - "+" is a broken link", false);

		}
		}
	
	public void get_all_links() {
		
		List<WebElement> links = DriverManagerUtility.getDriver().findElements(By.tagName("a"));
		
		
		for(WebElement link : links) {
//			@SuppressWarnings("deprecation")
			String url = link.getDomAttribute("href");
			if (url != null && !url.startsWith("http")) {
			    url = PropertiesUtil.getPropertyValue(ConfigPropertiesEnums.TESTSITEURL) + url; // Convert relative URL to absolute
			}
			else if(url ==null) {
				
				ExtentLogger.info("URL IS NULL"+ link.getTagName(), false);
				
			}
			verifyLink(url);
			
		}
		
		
		
	}
	
	
	//Newly setup 
	public static String getScreenshotPath() {
		TakesScreenshot ts = (TakesScreenshot)(DriverManagerUtility.getDriver());
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		File destFile = new File(
				FrameworkConstants.getScreenshotsFolderPath() + "/" + ReportManager.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return screenshot;
	}
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];
		
		Hashtable<String,String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String,String>();
			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;

	}
	
	
	public void verify_services_navigation(TestConstants webservices , String xpathstring) throws IOException {
		
		WebElement element = DriverManagerUtility.getDriver().findElement(By.xpath(DynamicUtilityAllocator.getXpath(xpathstring, webservices.getValue())))  ;
//		test.log(Status.INFO, "Checking for service naviagtion");
		ExtentLogger.info("Checking for service naviagtion", false);
		Assert.assertEquals(webservices.getValue(), element.getText());
		ExtentLogger.pass("Assertion passed trying to navigate", true);
//		test.log(Status.PASS, "Assertion passed trying to navigate" ,MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
		element.click();
		
		
		
		
		
	}

	
	public void verify_string(TestConstants con, WebElement element) {
		
		
		String s = con.getValue();
		String s2 = element.getText();
		if(s== s2) {
//			Assert.assertTrue(true);
			ExtentLogger.pass("passes", false);
			
		}
		else {
			ExtentLogger.fail("passes", false);
		}
		
		
	}

}
