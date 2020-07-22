package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ProcessingImage {
	
	//Below method to read the reference image path and return the Base64-encoded version of our image file
	public  String getReferenceImageB64(String refImage) throws IOException {
		String refImageFilePath = System.getProperty("user.dir")+"\\ImageCompare\\"+refImage+"";
	    File refImgFile = new File(refImageFilePath);
	    String refImageBase64=Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
		
		return refImageBase64;
	}
	
	//Below method to wait for the presence of Base64 encoded version of the file and click once find it
	public void waitAndClickImage(AndroidDriver<AndroidElement> driver, int waitingSec, String refImgName) throws IOException {
		
		 WebDriverWait wait=new WebDriverWait(driver,waitingSec);
	     By Base64Image = MobileBy.image(getReferenceImageB64(refImgName));
	     wait.until(ExpectedConditions.presenceOfElementLocated(Base64Image)).click();
	}

}
