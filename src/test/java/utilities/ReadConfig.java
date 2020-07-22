package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	// Properties Class
	Properties pro; 
	
	// Constructor
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
			// Creating File object
		try 
		{
			// Open FileInputStream and Read data 
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis); // Load config.properties file
		} 
		catch (Exception e) 
		{	
			// If config.properties file is not available it will throw an exception
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	// Methods to read data from config.properties 	
	public String getAppSrc()
	{
		String appsrc=pro.getProperty("appsrc");
		return appsrc;
	}
	
	public String getDeviceName()
	{
		String deviceName=pro.getProperty("devceName");
		return deviceName;
	}
	
	
}
