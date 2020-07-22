package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class GetImageB64 {
	
	//Below method to read the reference image and return the Base64-encoded version of our image file
	public  String getReferenceImageB64(String refImage) throws IOException {
		String refImageFilePath = System.getProperty("user.dir")+"\\ImageCompare\\"+refImage+"";
	    File refImgFile = new File(refImageFilePath);
	    String refImageBase64=Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
		
		return refImageBase64;
	}

}
