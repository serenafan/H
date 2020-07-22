package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.GetImageB64;

public class TutorialPage extends GetImageB64 {
	AndroidDriver<AndroidElement> driver;   
	public TutorialPage(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		
	}
	
	//Click Spin Button(Tutorial 1st step)
	public void clickSpinButton() throws IOException {
		WebDriverWait wait=new WebDriverWait(driver,5);
	     By spinImage = MobileBy.image(getReferenceImageB64("Spin.png"));
	     wait.until(ExpectedConditions.presenceOfElementLocated(spinImage)).click();
	}
	
	//click set bet to 100K
	public void clickSetBetButton() throws IOException {
		WebDriverWait wait=new WebDriverWait(driver,5);
	     By setBetImage = MobileBy.image(getReferenceImageB64("SetBet.png"));
	     wait.until(ExpectedConditions.presenceOfElementLocated(setBetImage)).click();
	}
	
	//click Complete button
	public void clickCompleteButton() throws IOException {
		WebDriverWait wait=new WebDriverWait(driver,200);
	     By completeImage = MobileBy.image(getReferenceImageB64("Complete.png"));
	     wait.until(ExpectedConditions.presenceOfElementLocated(completeImage)).click();
	}
	
	
	
	
	


}
