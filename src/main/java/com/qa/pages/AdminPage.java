/**
 * 
 */
package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.qa.DriverUtilities.DriverManagerUtility;
import com.qa.base.TestBase;
import com.qa.enums.TestConstants;
import com.qa.reportutil.ExtentLogger;
import com.qa.utilities.TestUtils;

/**
 * @author Ketan Tiwari
 *
 */
public class AdminPage extends TestBase{
	
	
	public AdminPage() {
		PageFactory.initElements(DriverManagerUtility.getDriver(), this);
	} 
	
	TestUtils utils = new TestUtils();
		
	@FindBy(xpath = "//button[@value= 'CLEAN']")
	WebElement Clean_button ; 
	
	@FindBy(xpath = "//button[@value= 'INIT']")
	WebElement Initialize_button ; 
	
	@FindBy(xpath= "//p//b[text()='Database Cleaned']")
	WebElement DataBase_clean_msg ; 
	
	@FindBy(xpath= "//p//b[text()='Database Initialized']")
	WebElement DataBase_initialize_msg ;
	
	
	public void clean_initialize_database() throws IOException, InterruptedException {
		
//		test.log(Status.INFO, "Cleaning the database");
		
		ExtentLogger.info("Cleaning the database", false);
//		utils.verify_string(, DataBase_clean_msg);
		Clean_button.click();
		Thread.sleep(2000);
//		utils.verify_string(TestConstants.DB_CLEAN, DataBase_clean_msg);
		System.out.println(DataBase_clean_msg.getText());
		ExtentLogger.info("Initializing the database", false);
//		test.log(Status.INFO, "Initializing the database");
//		utils.verify_string(, DataBase_clean_msg);
		Initialize_button.click();
//		utils.verify_string(TestConstants.DB_INITIALIZED, DataBase_initialize_msg);
		
//		test.log(Status.PASS, "DB Cleaned and Initialized " ,MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
		ExtentLogger.pass("DB Cleaned and Initialized", true);
	}
	
	

}
