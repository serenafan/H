package base;

import java.io.File;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import nu.pattern.OpenCV;
import utilities.ReadConfig;
import nu.pattern.OpenCV;

public class BaseClass {
	
	//Initiating android driver
	public static AndroidDriver<AndroidElement> driver; 
	
	//Initiating Appium service
	public static AppiumDriverLocalService service;
	
	//Initiating Logger
	public static Logger logger;


	
	//Below method will run before every test case to 
	//1. Start Appium server
	//2. Start android Emulator
	//3. Initiating AndroidDriver
	//4. Loading the OpenCV Library
	@BeforeMethod
	public static AndroidDriver<AndroidElement> Capabilities() throws IOException, InterruptedException {
		//Kill all nodes
	    killAllNodes();
	    
	    //Start appium server
	    startServer();
	    
	    //Start android Emulator
	    startEmulator();
	    
	    //Initiating logger
	    logger=Logger.getLogger("HuuugeCasino");// Project Name 
	    PropertyConfigurator.configure("log4j.properties"); // Added Logger
	    logger.setLevel(Level.DEBUG); // to get the debug log
	    logger.debug("Debug logging has started ");
		
	    //Get app apk from ReadConfig file
	    ReadConfig readConfig= new ReadConfig();
	    File appsrc=new File(readConfig.getAppSrc());
	    
	    //Set up desired capabilities(AUTOMATION_NAME, DEVICE_NAME, APP)for launch the AndroidDriver
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, readConfig.getDeviceName());
		cap.setCapability(MobileCapabilityType.APP, appsrc.getAbsolutePath());
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		//Loading OpenCV library
		OpenCV.loadShared();
		
		//Initiating implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;

	}
	
	//Below method will stop the appium server after each test case
	@AfterMethod
	public void quitserver() {
		driver.quit();
		service.stop();
		
	}
	
	
	
	//Kill all nodes
	public static void killAllNodes() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		
	}

	//Start appium server
	public static AppiumDriverLocalService startServer() throws IOException, InterruptedException {

		boolean flag=checkIfServerIsRunning(4723);
		if (!flag) {
			service=AppiumDriverLocalService.buildDefaultService();
			service.start();
			
		}
		return service;		 
	}

	//check if server is running
	public static boolean checkIfServerIsRunning(int port)  {
		
		boolean isRunning =false;
		ServerSocket  serverSocket;
		try {
			serverSocket= new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			isRunning =true;
		} finally {
			serverSocket=null;
		}
		return isRunning;
		
	}
	
	//Start emulator 
	public static void startEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\test\\java\\utilities\\startEmulator.bat");
		Thread.sleep(20000);
	}
	


}
