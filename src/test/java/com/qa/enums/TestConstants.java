/**
 * 
 */
package com.qa.enums;

/**
 * @author Ketan Tiwari
 *
 */
	public enum TestConstants {
		
		SOLUTIONS("Solutions"),
		ABOUT_US("About Us"),
		SERVICE("Services"),
		PRODUCTS("Products"),
		LOCATIONS("Locations"),
		ADMIN_PAGE("Admin Page"),
		
		DB_CLEAN("Database Cleaned"),
		DB_INITIALIZED("Database Initialized");
		
		
		private final String value ;
		TestConstants(String value){
			this.value = value;
			
			
			
		}
		 public String getValue() {
		        return value;
		    }

		
}
