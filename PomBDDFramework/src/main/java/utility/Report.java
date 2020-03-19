package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;

public class Report {

	public static String extentReportPath;
	public static String extentReportFileName;
	
	public static void extentEnvironmentInfo()
	{
		
		
		System.out.println("extentEnvironmentInfo method is called");
		
	    Reporter.loadXMLConfig(new File("src/test/resources/Config/extent-config.xml"));
	    
	   
	    Reporter.setSystemInfo("<b>OperatingSystem</b>", System.getProperty("os.name"));
	    Reporter.setSystemInfo("<b>ProjectPath</b>", System.getProperty("user.dir"));
	    Reporter.setSystemInfo("<b>JavaVersion: </b>", System.getProperty("java.version"));
	    
	    Reporter.setTestRunnerOutput("Demo");
	   
	}
	
	public static void setExtentReport()
	{
		System.out.println("Extent Report Set Up");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy h-mm-ss a");
		
		String formattedDate = sdf.format(date);
		
	    ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	    extentReportFileName = "myExtentReport"+formattedDate.toString()+".html";
	    
	    extentReportPath = "target/ExetentReport/"+extentReportFileName;
	    extentProperties.setReportPath(extentReportPath);
	}
}
