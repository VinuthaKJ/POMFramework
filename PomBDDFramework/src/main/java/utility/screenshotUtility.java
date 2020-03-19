package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshotUtility extends TestBase{

	
	public static String getScreenshot() throws Exception {
		
		

		
		TakesScreenshot ts = (TakesScreenshot) driver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		return  "data:image/jpg;base64, " + src ;
		
	}
}
 