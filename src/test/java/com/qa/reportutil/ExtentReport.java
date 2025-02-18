/**
 * 
 */
package com.qa.reportutil;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.qa.constants.FrameworkConstants;
import com.qa.enums.ConfigPropertiesEnums;
import com.qa.utilities.PropertiesUtil;

/**
 * @author Ketan Tiwari
 *
 */
public final class ExtentReport {
	
	/**
	 * 
	 */
	private ExtentReport() {
		// TODO Auto-generated constructor stub
	}

	
	
	private static ExtentReports extent ; 
	private static ExtentTest test ; 
	
	
	public static void extentinitializer() throws IOException {
		
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
		}
		if (PropertiesUtil.getPropertyValue(ConfigPropertiesEnums.ALLTESTS).equalsIgnoreCase("yes")) {
			
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getAlltestreportpath());
			spark.loadJSONConfig(new File(FrameworkConstants.getJsonConfigAlltestsFilePath()));
			spark.viewConfigurer().viewOrder()
			.as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY }).apply();
			
			extent.attachReporter(spark);
		}
		
		if (PropertiesUtil.getPropertyValue(ConfigPropertiesEnums.ONLYFAILEDTESTS).equalsIgnoreCase("yes")) {
			
			ExtentSparkReporter spark_onlyfailed = new ExtentSparkReporter(FrameworkConstants.getFailedreportpath());
			spark_onlyfailed.loadJSONConfig(new File(FrameworkConstants.getJsonConfigOnlyfailedFilePath()));
			spark_onlyfailed.viewConfigurer().viewOrder()
			.as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY }).apply();
			
			extent.attachReporter(spark_onlyfailed);
		}
			
	}
	
	public static void reportflush() {
		
		if(Objects.nonNull(extent)) {
			extent.flush();
			ExtentReportManager.unload();
		}
		
	}
	
	public static void createtest(String testcasename) {
		
		test = extent.createTest(testcasename);
		ExtentReportManager.setExtTest(test);
	}
	
	
}
