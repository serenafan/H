package pageObjects;

import java.io.IOException;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.ProcessingImage;

public class LandingPage extends ProcessingImage {
	AndroidDriver<AndroidElement> driver;   
	public LandingPage(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		
	}
	
    //Find allow button 
    @AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
    WebElement allowBtn;
    
    //Find Huuuge Casino icon
    @AndroidFindBy(xpath="//*[@text='Huuuge Casino']")
    WebElement HugeCasinoIcon;
	
	//Click Ok Button
	public void clickOkButton() throws IOException {
		waitAndClickImage(driver,5,"okButton.png");
	}
	
	//click allow on access button
	public void clickAllowButton() throws IOException {
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(allowBtn)).click();
	    
	}
	
	//Open the game again
	public void clickIntoGame() throws IOException {
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(HugeCasinoIcon)).click();
	    
	}
	
	//Accept legal document
	public void clickAcceptButton() throws IOException {
		waitAndClickImage(driver,200,"Accept.png");
	}
	
	
	//Click play as guest on "who are you" popup
	public void clickPlayGuestBtn() throws IOException {
		waitAndClickImage(driver,10,"PlayAsGuest.png");
	}
	
	
	//Click "God of SKy" button
	public void clickGodOfSky() throws IOException {
		waitAndClickImage(driver,5,"godOfSky.png");
	}
	

}
