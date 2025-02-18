package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.DriverUtilities.DriverManagerUtility;
import com.qa.enums.ConfigPropertiesEnums;
import com.qa.reportutil.ExtentReport;
import com.qa.utilities.ExcelReader;
import com.qa.utilities.PropertiesUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
//import com.relevantcodes.extentreports.LogStatus;







public class TestBase {



	// Webdriver Ini
	//properties 
	//logs
	//extent reports
	//DB 
	//excel
	//mail

	public static Logger log  = LogManager.getLogger(TestBase.class);

	public static String browser;

	public static WebDriverWait wait;

	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\TestData.xlsx");



//	public static ExtentReports report = new ExtentReports() ;
//	public static ExtentSparkReporter spark;
//	public static ExtentTest test;

//	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	//


	//	public static WebDriver getdriver() {
	//		return driver.get();
	//
	//	}
	


	@BeforeMethod
	public void setUp() throws IOException {
//		ExtentReport.extentinitializer();
		DriverManagerUtility.initializeDriver(PropertiesUtil.getPropertyValue(ConfigPropertiesEnums.BROWSER));
		
		
	}





	@AfterMethod
	public void teardown() {
		if(DriverManagerUtility.getDriver() != null) {
			DriverManagerUtility.quit_driver();
		}
//		ExtentReport.reportflush();

	}


//	public boolean iselementPresent(By by) {
//		try {
//			getdriverinstance().findElement(by);
//			return true;
//		} catch (NoSuchElementException e) {
//			return false;
//
//			
//		}



//	}


//	@BeforeClass
//	public static void startTest() {
//
//		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/Extentreports/extent.html");
//		spark.config().setTheme(Theme.DARK);
//		report.attachReporter(spark);
//
//
//	}
//
//	@AfterClass
//	public static void endTest() {
//
//		report.flush();
//
//
//
//
//
//	}



}


