package utility;







//import org.testng.TestListenerAdapter;
import org.testng.IInvokedMethod;

import org.testng.IInvokedMethodListener;

import org.testng.ISuite;

import org.testng.ISuiteListener;

import org.testng.ITestContext;

import org.testng.ITestListener;

import org.testng.ITestNGMethod;

import org.testng.ITestResult;

import org.testng.Reporter;

import com.github.mkolisnyk.cucumber.reporting.CucumberBenchmarkReport;
import com.github.mkolisnyk.cucumber.reporting.types.benchmark.BenchmarkReportInfo;
import com.github.mkolisnyk.cucumber.reporting.types.benchmark.BenchmarkReportModel;


@SuppressWarnings("unused")
//public class ListnerTestNG implements ITestListener, ISuiteListener, IInvokedMethodListener 
public class ListenerTestng implements ISuiteListener, ITestListener
{

	// This belongs to ISuiteListener and will execute before the Suite start

	@Override

	public void onStart(ISuite arg0) {

		
		System.out.println("Executiing before suite method");
		try {
			
			CommonMethods.closeWebDriverProcess();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Catch block of onStart method");
			e.printStackTrace();
		}

	}

	// This belongs to ISuiteListener and will execute, once the Suite is finished

	@Override

	public void onFinish(ISuite arg0) {

		//Reporter.log("About to end executing Suite " + arg0.getName(), true);
		System.out.println("AfterSuite Started");
		try {
//			CommonMethods.closeWebDriverProcess();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try {
			//Report.cucumberConsolidatedReport();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	// This belongs to ITestListener and will execute before starting of Test set/batch 

	public void onStart(ITestContext arg0) {

		
		System.out.println("Before Class Method Started");
		Report.setExtentReport();
		

	}

	// This belongs to ITestListener and will execute, once the Test set/batch is finished

	public void onFinish(ITestContext arg0) {

		
		System.out.println("After Class Method Started");
		Report.extentEnvironmentInfo();  
		System.out.println("After Class Method Finshed");
	}

	// This belongs to ITestListener and will execute only when the test is pass

	public void onTestSuccess(ITestResult arg0) {

		// This is calling the printTestResults method

		printTestResults(arg0);

	}

	// This belongs to ITestListener and will execute only on the event of fail test

	public void onTestFailure(ITestResult arg0) {

		// This is calling the printTestResults method

		printTestResults(arg0);

	}

	// This belongs to ITestListener and will execute before the main test start (@Test)

	public void onTestStart(ITestResult arg0) {

		System.out.println("The execution of the main test starts now");

	}

	// This belongs to ITestListener and will execute only if any of the main test(@Test) get skipped

	public void onTestSkipped(ITestResult arg0) {

		printTestResults(arg0);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	// This is the method which will be executed in case of test pass or fail

	// This will provide the information on the test

	private void printTestResults(ITestResult result) {

		Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);

		if (result.getParameters().length != 0) {

			String params = null;

			for (Object parameter : result.getParameters()) {

				params += parameter.toString() + ",";

			}

			Reporter.log("Test Method had the following parameters : " + params, true);

		}

		String status = null;

		switch (result.getStatus()) {

		case ITestResult.SUCCESS:

			status = "Pass";

			break;

		case ITestResult.FAILURE:

			status = "Failed";

			break;

		case ITestResult.SKIP:

			status = "Skipped";

		}

		Reporter.log("Test Status: " + status, true);

	}



}