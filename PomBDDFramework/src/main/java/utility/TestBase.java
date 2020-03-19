package utility;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class TestBase {

	public static WebDriver driver;
	
	
	public static void OpenApplication()
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\Webdrivers\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", path);

		
		
		ChromeOptions options = new ChromeOptions();
		
		
		
		Map<String,Object> pref = new HashMap<String, Object>();
		pref.put("profile.exit_type", "none");
		pref.put("profile.exited_cleanly", Boolean.valueOf("True"));
		options.setExperimentalOption("prefs", pref);
		options.addArguments("--disable-notifications");
		options.addArguments("disable-infobars");
		
		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		options.setCapability("exit_type", "none");	
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
	driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
//		 driver=new ChromeDriver();
//		    driver.manage().window().maximize();
//			driver.manage().deleteAllCookies();
//			driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
//			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		

		
		
		
		
	}
	
	
	

	
}
