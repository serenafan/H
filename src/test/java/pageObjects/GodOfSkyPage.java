package pageObjects;

import java.io.IOException;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.ProcessingImage;

public class GodOfSkyPage extends ProcessingImage {
	AndroidDriver<AndroidElement> driver;   
	public GodOfSkyPage(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		
	}
	
	//Click Ok Button
	public void selectBeginnerGame() throws IOException {
		waitAndClickImage(driver,100,"Beginner.png");
	}
	
	//Open profile
	public void clickProfile() throws IOException {
		waitAndClickImage(driver,200,"Profile.png");
	}
	
	
	//verify edit profile is displayed
	public boolean verifyEditProfile() {
		List<AndroidElement> editProfile =driver.findElementsByImage("EditProfile.png");
		 if(editProfile.size()>0)
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
		
	}
	
	
	//Close profile
	public void closeProfile() throws IOException {
		waitAndClickImage(driver,5,"Close.png");
	}


}
