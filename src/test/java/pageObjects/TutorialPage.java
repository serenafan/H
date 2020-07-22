package pageObjects;

import java.io.IOException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.ProcessingImage;

public class TutorialPage extends ProcessingImage {
	AndroidDriver<AndroidElement> driver;   
	public TutorialPage(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		
	}
	
	//Click Spin Button(Tutorial 1st step)
	public void clickSpinButton() throws IOException {
		waitAndClickImage(driver,200,"Spin.png");

	}
	
	//click set bet to 100K
	public void clickSetBetButton() throws IOException {
		waitAndClickImage(driver,10,"SetBet.png");
	}
	
	//click Complete button
	public void clickCompleteButton() throws IOException {
		waitAndClickImage(driver,200,"Complete.png");
	}
	
	
	
	
	


}
