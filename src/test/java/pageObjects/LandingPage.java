package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.GetImageB64;

public class LandingPage extends GetImageB64 {
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
		WebDriverWait wait=new WebDriverWait(driver,5);
	     By okImage = MobileBy.image(getReferenceImageB64("okButton.png"));
	     wait.until(ExpectedConditions.presenceOfElementLocated(okImage)).click();
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
		WebDriverWait wait=new WebDriverWait(driver,200);
	     By acceptImage = MobileBy.image(getReferenceImageB64("Accept.png"));
	     wait.until(ExpectedConditions.presenceOfElementLocated(acceptImage)).click();
	}
	
	
	//Click play as guest on "who are you" popup
	public void clickPlayGuestBtn() throws IOException {
		WebDriverWait wait=new WebDriverWait(driver,200);
	     By playGuestImg = MobileBy.image(getReferenceImageB64("PlayAsGuest.png"));
	     wait.until(ExpectedConditions.presenceOfElementLocated(playGuestImg)).click();
	}
	
	
	//Click "God of SKy" button
	public void clickGodOfSky() throws IOException {
		WebDriverWait wait=new WebDriverWait(driver,200);
	     By godSkyImg = MobileBy.image(getReferenceImageB64("godOfSky.png"));
	     wait.until(ExpectedConditions.presenceOfElementLocated(godSkyImg)).click();
	}
	

}
