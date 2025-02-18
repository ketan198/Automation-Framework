
package com.qa.testcases;
import org.openqa.selenium.By;
//import com.qa.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RoughTest {
	
//	@FindBy(xpath = "//textarea[@id='APjFqb']")
//	WebElement ele;
	
	 protected static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	 
	 public static WebDriver getdriverinstance(){
		 return driver.get();
	    }
	 	
	
	 
	
	 
    @BeforeMethod
//    @Parameters("browser")
    public void initialize() {
    	
    	WebDriverManager.chromedriver().setup();
    	driver.set(new ChromeDriver());
    }
    
    
   
	public void inputsomething(WebElement ele,String xyz) {
		
		ele.sendKeys(xyz);
		
		
		
		
		
		

	}

    @Test
    public void testGoogleHomePage() throws InterruptedException {
    	
    	getdriverinstance().get("https://www.google.co.in/");
    	Thread.sleep(3000);
    	inputsomething(getdriverinstance().findElement(By.xpath("//textarea[@id='APjFqb']")), "random string");
    	Thread.sleep(3000);
    	Thread.sleep(3000);
       
    }
    
    @Test
    public void testGoogleHomePagea() throws InterruptedException {
    	
    	getdriverinstance().get("https://www.google.co.in/");
    	Thread.sleep(3000);
    	inputsomething(getdriverinstance().findElement(By.xpath("//textarea[@id='APjFqb']")), "sadasdada");
    	Thread.sleep(3000);
    	Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
    	getdriverinstance().quit();
    	driver.remove();
    }
}