package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vimalselvam.cucumber.listener.Reporter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.FindBy;

import utility.TestBase;
import utility.screenshotUtility;

public class FlipkartPages extends TestBase{

	
	public String VUTVPrice;
	public static String FinalPrice;
	public static String VUTVPriceTwo;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement UsernameTxtbox;
	
	
	
	@FindBy(xpath="//input[@type='password']")
	WebElement PwdTxtbox;
	
	@FindBy(xpath="(//div//span[text()='Login'])[2]")
	WebElement LoginBtn;
			
	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	WebElement SearchTxtbox;
	
	@FindBy(xpath="//div[@class='_1vC4OE _2rQ-NK']")
	List<WebElement> FirstItem;
	
	@FindBy(xpath="//div[@class='_1vC4OE _3qQ9m1']")
	WebElement PriceAmt;
	
	@FindBy(xpath="//button[text()='ADD TO CART']")
	WebElement AddtoCartBtn;
	
	
	@FindBy(xpath="//button[text()='+']")
	WebElement PlusBtn;
	
	@FindBy(xpath="//span[@class='pMSy0p XU9vZa']")
	WebElement IncreasedPriceAmt;
	
	
	@FindBy(xpath="//div[text()='Total Amount']/../span//div//span")
	WebElement TotalAmt;
	Actions action=new Actions(driver);
			
		public 	FlipkartPages()
		{
			PageFactory.initElements(driver, this);
		}
	
	
		public void LoginToFilpkart(String username, String pwd) throws Throwable
		{
			
			
			
			action.sendKeys(Keys.ESCAPE).build().perform();
			
//			UsernameTxtbox.sendKeys(username);
//			PwdTxtbox.sendKeys(pwd);
//			LoginBtn.click();
			Thread.sleep(5000);
			
			
			
		}
			

		public void SearchValue(String value) throws Throwable
		{
			SearchTxtbox.sendKeys(value);
			SearchTxtbox.sendKeys(Keys.ENTER);
			SearchTxtbox.sendKeys(Keys.ENTER);
			Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot()); 
			Thread.sleep(8000);
		}
		
		public void ClickOnFirstItem() throws Throwable
		{	
			
			
			

			FirstItem.get(0).click();
			System.out.println("selected the first Item");
			String ParentWindow=driver.getWindowHandle();
			for(String winHandle : driver.getWindowHandles()){
		         driver.switchTo().window(winHandle);
		     }
		     driver.manage().window().maximize() ;
		     Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot()); 
		     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		     VUTVPrice =PriceAmt.getText();
		     System.out.println( VUTVPrice.replace("?",""));
		    System.out.println("The VU tv price in the flipkart is:   "+VUTVPrice);
		     
		     
		}
		
		public void PrintTheFinalPriceAfterAddingProdcut() throws Throwable
		{
			Thread.sleep(10000);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();",AddtoCartBtn);
			AddtoCartBtn.click();
			Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot());
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='+']")));
			js.executeScript("arguments[0].click();",PlusBtn);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			System.out.println("increased the Quantity by 1");
			Thread.sleep(5000);
			//VUTVPriceTwo=IncreasedPriceAmt.getText();
			System.out.println("Final Price of the product" + " "+TotalAmt.getText());
			//System.out.println("Final Price of the product" + " "+VUTVPriceTwo);
			Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot()); 
		}
		
		
		public void AddProductToTheCart() throws Throwable
		{
			Thread.sleep(10000);
			Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot());
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();",AddtoCartBtn);
			AddtoCartBtn.click();
			//VUTVPriceTwo=IncreasedPriceAmt.getText();
			Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot());
			FinalPrice=TotalAmt.getText();
			System.out.println("Final Price of the " + " "+FinalPrice);
			
//			String s2=FinalPrice.replaceAll("\\D", "");
//			System.out.println(s2+"heyyyyyyyyyyyyyyyyyyyy");
			//System.out.println("s2 is---------"+ s2);
			Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot());
			
		}
	
		
	
}
