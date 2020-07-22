package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.GetImageB64;

public class GodOfSkyPage extends GetImageB64 {
	AndroidDriver<AndroidElement> driver;   
	public GodOfSkyPage(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		
	}
	
	//Click Ok Button
	public void selectBeginnerGame() throws IOException {
		WebDriverWait wait=new WebDriverWait(driver,5);
	     By beginnerImage = MobileBy.image(getReferenceImageB64("Beginner.png"));
	     wait.until(ExpectedConditions.presenceOfElementLocated(beginnerImage)).click();
	}
	
	//Open profile
	public void clickProfile() throws IOException {
		WebDriverWait wait=new WebDriverWait(driver,5);
	     By profileImage = MobileBy.image(getReferenceImageB64("Profile.png"));
	     wait.until(ExpectedConditions.presenceOfElementLocated(profileImage)).click();
	}
	
	//verify edit profile is displayed
	public boolean verifyEditProfile() {
		List<AndroidElement> editProfile =driver.findElementsByImage("Profile.png");
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
		WebDriverWait wait=new WebDriverWait(driver,5);
	     By profileImage = MobileBy.image(getReferenceImageB64("Profile.png"));
	     wait.until(ExpectedConditions.presenceOfElementLocated(profileImage)).click();
	}


}
