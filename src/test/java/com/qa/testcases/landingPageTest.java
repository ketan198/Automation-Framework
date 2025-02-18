package com.qa.testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import com.qa.base.TestBase;
import com.qa.utilities.TestUtils;

/**
 * @author Ketan Tiwari
 *
 */
public class landingPageTest extends TestBase{

	
	TestUtils ut = new TestUtils();
	
	
	@Test
	public void landingpage() throws IOException {
//		test = report.createTest("test ");
		log.debug("Inside the test class ");
//		Assert.assertTrue(iselementPresent(By.xpath(OR.getProperty("bankLogo_XPATH"))))	;
		
//		test.log(Status.PASS, "Passed Succesfully");
//		
//		
//		test.log(Status.PASS, "Passed asdas");
//
//		test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(TestUtils.Base64getScreenshot()).build());
//		
//		test.log(Status.INFO, "Checking for broken URL links");
		
		ut.get_all_links();
		
		
		
	}	
	
	
	
	
}
