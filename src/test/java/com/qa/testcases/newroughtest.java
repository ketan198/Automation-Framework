/**
 * 
 */
package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Ketan Tiwari
 *
 */
public class newroughtest {
	
// protected static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	
	public static WebDriver driver;
	 
//	 public static WebDriver getdriverinstance(){
//		 return driver.get();
//	    }
	 	
	
	 
	
	 
    @BeforeMethod
//    @Parameters("browser")
    public void initialize() {
    	
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    }
    
    
   
	public void inputsomething(WebElement ele,String xyz) {
		
		ele.sendKeys(xyz);
		
		
		
		
		
		

	}

    @Test
    public void testGoogleHomePage() throws InterruptedException {
    	
    	driver.get("https://www.google.co.in/");
    	Thread.sleep(3000);
    	inputsomething(driver.findElement(By.xpath("//textarea[@id='APjFqb']")), "random string");
    	Thread.sleep(3000);
    	Thread.sleep(3000);
       
    }
    
    @Test
    public void testGoogleHomePagea() throws InterruptedException {
    	
    	driver.get("https://www.google.co.in/");
    	Thread.sleep(3000);
    	inputsomething(driver.findElement(By.xpath("//textarea[@id='APjFqb']")), "sadasdada");
    	Thread.sleep(3000);
    	Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
    	driver.quit();
//    	driver.remove();
    }

}
