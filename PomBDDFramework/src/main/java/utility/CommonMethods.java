package utility;

public class CommonMethods {

	
	
	
	

public static void closeWebDriverProcess() throws Exception {

	

		System.out.println("In closeWebDriverProcess");
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");

	

	

}
}