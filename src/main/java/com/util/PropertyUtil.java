package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyUtil {
	
	static Properties prop =null;
	   /*public static void main(String args[]) throws IOException 
	   {
	      Properties prop = readPropertiesFile("src/main/resources/config.properties");
	      System.out.println("username: "+ prop.getProperty("username"));
	      System.out.println("password: "+ prop.getProperty("password"));
	   }*/
		public PropertyUtil(){
			if(prop==null)
			  prop = readPropertiesFile("src/main/resources/config.properties");
		}
	   public Properties readPropertiesFile(String fileName){
	      FileInputStream fis = null;
	      try {
	         fis = new FileInputStream(fileName);
	         prop = new Properties();
	         prop.load(fis);
	      } 
	      catch(FileNotFoundException fnfe) 
	      {
	         fnfe.printStackTrace();
	      } 
	      catch(IOException ioe) 
	      {
	         ioe.printStackTrace();
	      } 
	      finally {
	    	  try {
	    		  fis.close();
	    	  } catch(Exception e) {
	    		  System.out.println("Exception while closing the inputstream. Skipping the exception.");
	    	  }
	      }
	      return prop;
	   }
	   public static String getProperty(String propName) {
		   return prop.getProperty(propName);
	   }
}
