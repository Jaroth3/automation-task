package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

	 	private static PropertyManager instance;
	    private static final Object lock = new Object();
	    private static String propertyFilePath = "D:\\CMS_3_1\\QAAutomation\\automation-task\\src\\main\\resources\\properties\\configuration.properties";
	    private static String url;
	    private static String browser;


	    public static PropertyManager getInstance () {
	        if (instance == null) {
	            synchronized (lock) {
	                instance = new PropertyManager();
	                instance.loadData();
	            }
	        }
	        return instance;
	    }
	    
	    private void loadData() {
	        //Declare a properties object
	        Properties prop = new Properties();
	 
	        //Read configuration.properties file
	        try {
	            prop.load(new FileInputStream(propertyFilePath));
	        } catch (IOException e) {
	            System.err.println("Configuration properties file cannot be found!");
	        }
	 
	        //Get properties from configuration.properties
	        url = prop.getProperty("Url");
	        browser = prop.getProperty("Browser");
	    }
	 
	    public String getURL () {
	      return url;
	    }
	    
	    public String getBrowser () {
		  return browser;
		}    
}
