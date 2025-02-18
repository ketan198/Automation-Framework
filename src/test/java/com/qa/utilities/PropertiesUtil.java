/**
 * 
 */
package com.qa.utilities;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

import com.qa.constants.FrameworkConstants;
import com.qa.enums.ConfigPropertiesEnums;

/**
 * @author Ketan Tiwari
 *
 */

// Since this is utility class hence ,  have restricted the unnecessary creation of objects for this class by declaring the custructo
//as private , hance made it as final as well so that no other class can inherit its properties.
public final class PropertiesUtil {
	
	private PropertiesUtil() {
		
	}
	public static final Properties PROP = new Properties();
	
	
	static {
		try {
			FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigfile());
			PROP.load(fis);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	
	public static String getPropertyValue(ConfigPropertiesEnums key) {
		
		if(PROP.getProperty(key.toString().toLowerCase())== null) {
			throw new RuntimeException("The Field in property file are null please check"); // This Checks the value of cofig.properties 
		}
		if(Objects.isNull(key)) {
			throw new RuntimeException("There is no property key defined in the COnfigPropertiesEnums");
		}
		return PROP.getProperty(key.toString().toLowerCase());
		
	}

}
