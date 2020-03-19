package objects;

import org.openqa.selenium.WebElement;
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

import utility.TestBase;
import utility.screenshotUtility;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.FindBy;

public class AmazonPages extends TestBase{

	
	
	public String FirstPhonePrice;
	public String TotalPrice;
	
	@FindBy(id="twotabsearchtextbox")
	public WebElement SearchTxtbox;
	
	
	@FindBy(xpath="//a//span[contains(text(),'Apple iPhone')]")
	public List<WebElement> ListItems;
	
	@FindBy(xpath="(//td[text()='Price:']/following-sibling::td//span)[1]")
	public WebElement Productprice;
	
	
	@FindBy(id="add-to-cart-button")
	public WebElement AddToCartBtn;	
	
	
	@FindBy(xpath="(//b[text()='Cart subtotal'])[1]/parent::span//following-sibling::span")
	public WebElement CartPrice;	
	
	public AmazonPages()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void EnterSearchValue(String value) throws Throwable
	{
		SearchTxtbox.sendKeys(value);
		SearchTxtbox.sendKeys(Keys.ENTER);
		SearchTxtbox.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot());
		
	}
	
	public void ClickOnFirstItem() throws Throwable
	{	
		
	
		ListItems.get(0).click();
		System.out.println("selected the first Item");
		Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot());
		String ParentWindow=driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
	         driver.switchTo().window(winHandle);
	     }
	     driver.manage().window().maximize() ;
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot());
	     FirstPhonePrice =Productprice.getText();
	     
	    System.out.println("The product price in the flipkart is:   "+FirstPhonePrice);
	     
	     
	}
	
	public void AddProductToTheCart() throws Throwable
	{
		Thread.sleep(10000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AddToCartBtn);
		 
		Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot());
		TotalPrice=CartPrice.getText();
		System.out.println("Final Price of the product" + " "+TotalPrice);
		
	}
	
	public void ComParePrices() throws Throwable {
		
		Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot());
		String value1=FlipkartPages.FinalPrice;
		
		
		
		String value2=value1.replaceAll("\\D", "");
		System.out.println(value2);
		
		int Flipartvalue1=Integer.parseInt(value2);
		
		System.out.println("valueOne is "+"-----------"+value2);
		TotalPrice=TotalPrice.replace(".00","").trim().replaceAll("\\D", "");
		System.out.println("value2 is "+"-----------"+TotalPrice);
		int amazonvalue2=Integer.parseInt(TotalPrice);
		Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot());
		if(Flipartvalue1<amazonvalue2)
		{
			System.out.println("flipkart is giving the cheaper rates");
		}
		
		
		
		else if(Flipartvalue1==amazonvalue2)
		{
			System.out.println("flipkart and amazon both are giving the same rates");	
		}
		else if(Flipartvalue1>amazonvalue2)
		{
			System.out.println("amazon having highest cost");
		}
		
	}
}
