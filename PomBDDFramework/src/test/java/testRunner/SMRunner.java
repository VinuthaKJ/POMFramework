package testRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.Listeners;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.github.mkolisnyk.cucumber.runner.ExtendedTestNGRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import utility.ListenerTestng;
import utility.Report;





			
	
	






@ExtendedCucumberOptions(
jsonReport = "target/cucumber/cucumber.json",
jsonUsageReport = "target/cucumber/cucumber-usage.json",
outputFolder = "target/AdvancedReport/",
detailedReport = true,
detailedAggregatedReport = true,
overviewChartsReport = true,
overviewReport = true,
featureOverviewChart = true,
usageReport = true,
coverageReport = false,
systemInfoReport = true,
retryCount = 0,
toPDF = false,

includeCoverageTags = {""})




@CucumberOptions(
		
		features = {"src/test/java/smTestSuite/featureFiles"},
			
		glue = {"smTestSuite/steps/stepDefinition"},
		monochrome = true, 
		dryRun = false,
		
		tags = {"@SmokeTest"},
						
		
		strict = true,
		
		plugin = {"pretty:target/cucumber/pretty.txt",
				"html:target/cucumber",
				"json:target/cucumber/cucumber.json",
				"usage:target/cucumber/cucumber-usage.json",
				"junit:target/XML/Cucumber.xml",
				"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"}	
		)

	


	
	

	


@Listeners(ListenerTestng.class)

public class SMRunner extends ExtendedTestNGRunner{	
	
@org.testng.annotations.AfterClass()
	
	public static void teardown1()  {
	
	Report.extentEnvironmentInfo();  
	
}


}
