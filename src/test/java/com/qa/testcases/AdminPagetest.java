/**
 * 
 */
package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.xml.internal.TestNamesMatcher;

import com.github.dockerjava.transport.DockerHttpClient.Request.Method;
import com.qa.base.TestBase;
import com.qa.listners.CustomListeners;
import com.qa.pages.AdminPage;
import com.qa.pages.homePage;
import com.qa.reportutil.ExtentReport;

/**
 * @author Ketan Tiwari
 *
 */
@Listeners(CustomListeners.class)
public class AdminPagetest extends TestBase {
	
	homePage hp ; 
	AdminPage ad; 
	
	@Test(testName = "Admin Page")
	public void Initilizewebsite_test() throws IOException, InterruptedException {
//		test = report.createTest("test adminpage");
//		ExtentReport.createtest();
		hp = new homePage();
		ad = hp.navigate_to_AdminPage();
		ad.clean_initialize_database();
		
	}

}
