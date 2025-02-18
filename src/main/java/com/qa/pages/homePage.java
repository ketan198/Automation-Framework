package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.enums.TestConstants;
import com.qa.utilities.TestUtils;




public class homePage extends TestBase{
	
	public homePage() {
		
		
	}
	
	TestUtils util = new TestUtils();
	
	private static final String webservice = "//ul[@class='leftmenu']//descendant::li//a[contains(text(),'%s')]";
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement Register_link ; 
	
	@FindBy(xpath = "//p//b[text()='Username']/..//following-sibling::div//input[@name='username']")
	WebElement User_name ;
	
	@FindBy(xpath = "//p//b[text()='Username']/..//following-sibling::div//input[@name='password']")
	WebElement Password; 
	
	@FindBy(xpath = "//input[@value='Log In']")
	WebElement Login_button;
	
	
	
	
	public AdminPage navigate_to_AdminPage() throws IOException{
		
		util.verify_services_navigation(TestConstants.ADMIN_PAGE, webservice);
		
		return new AdminPage();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
