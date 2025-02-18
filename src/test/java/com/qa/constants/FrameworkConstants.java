/**
 * 
 */
package com.qa.constants;



import com.qa.reportutil.ReportManager;

/**
 * @author Ketan Tiwari
 *
 */
public final class FrameworkConstants {
	

	private FrameworkConstants() {
		
	}

	
	private static final String CONFIGFILE =  System.getProperty("user.dir")+ "/src/test/resources/properties/config.properties"; 
	private static final String EXTENT_REPORTS = System.getProperty("user.dir")+ "";
	private static final String JSON_CONFIG_ALLTESTS_FILE_PATH = "src/test/resources/extentconfigs/extentconfig-spark-all.json";
	private static final String JSON_CONFIG_ONLYFAILED_FILE_PATH = "src/test/resources/extentconfigs/extentconfig-spark-onlyfailed.json";
	
	private static String alltestreportpath =  "test-reports/"  + ReportManager.getReportFolderName() + "/reports/report_alltests.html";
	private static String failedreportpath = "test-reports/" + ReportManager.getReportFolderName()
	+ "/reports/report_onlyfailedtests.html";
	private static String screenshotsFolderPath = "test-reports/" + ReportManager.getReportFolderName()
	+ "/screenshots";
	
	
	
	public static String getConfigfile() {
		return CONFIGFILE;
	}
	public static String getAlltestreportpath() {
		return alltestreportpath;
	}
	public static String getScreenshotsFolderPath() {
		return screenshotsFolderPath;
	}
	public static String getJsonConfigAlltestsFilePath() {
		return JSON_CONFIG_ALLTESTS_FILE_PATH;
	}
	public static String getJsonConfigOnlyfailedFilePath() {
		return JSON_CONFIG_ONLYFAILED_FILE_PATH;
	}
	public static String getFailedreportpath() {
		return failedreportpath;
	}
	public static String getExtentReports() {
		return EXTENT_REPORTS;
	}

	
	
	
}
