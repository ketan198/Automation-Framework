/**
 * 
 */
package com.qa.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

/**
 * @author Ketan Tiwari
 *
 */
public class RegisterPage extends TestBase{
	
	public RegisterPage() {
		
		
		
	}
	

	@FindBy(xpath = "//input[@name='customer.firstName']")
	WebElement First_name;

	@FindBy(xpath = "//input[@name='customer.lastName']")
	WebElement Last_name;
	
	@FindBy(xpath = "//input[@name='customer.address.street']")
	WebElement Address;

	@FindBy(xpath = "//input[@name='customer.address.city']")
	WebElement City;
	
	@FindBy(xpath = "//input[@name='customer.address.state']")
	WebElement State;

	@FindBy(xpath = "//input[@name='customer.address.zipCode']")
	WebElement Zip_code;

	@FindBy(xpath = "//input[@name='customer.phoneNumber']")
	WebElement Phone;
	
	@FindBy(xpath = "//input[@name='customer.ssn']")
	WebElement SSN;

	@FindBy(xpath = "//input[@name='customer.username']")
	WebElement User_name;

	@FindBy(xpath = "//input[@name='customer.password']")
	WebElement Password;
	
	@FindBy(xpath = "//input[@name='repeatedPassword']")
	WebElement Confirm_password;
	
	
	
	public homePage register_new_user(String firstname, String lastname , String address , String city , String state
			,String zip , String phone , String ssn , String user_name , String password , String cnf_pass) {
		
		First_name.sendKeys(firstname);
		Last_name.sendKeys(lastname);
		Address.sendKeys(address);
		City.sendKeys(city);
		State.sendKeys(state);
		Zip_code.sendKeys(zip);
		Phone.sendKeys(phone);
		SSN.sendKeys(ssn);
		User_name.sendKeys(user_name);
		Password.sendKeys(password);
		Confirm_password.sendKeys(cnf_pass);
		return new homePage();
		
	}


}
