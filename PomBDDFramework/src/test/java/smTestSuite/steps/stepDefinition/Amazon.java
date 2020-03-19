package smTestSuite.steps.stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import objects.AmazonPages;
import objects.FlipkartPages;
import utility.TestBase;

public class Amazon extends TestBase {

	AmazonPages AmazonPagesobjects ;
	
	 @Given("^open Chrome Browser$")
	 public void open_Browsers() throws Throwable
	 {
		 TestBase.OpenApplication();
		 AmazonPagesobjects=new AmazonPages(); 
		 
	 }
	
	 
	 
	 @And("^Enter Amazon URL$")
	 public void Enter_Flipkart_URL()throws Throwable{
		 
		 String url="http://www.amazon.in";
		 driver.get(url);
	 }
	
	
	 @Then("^Enter Amzon Product name in searchTextbox$")
	    public void Enter_Product_name_in_searchTextbox() throws Throwable{
	    	
		 AmazonPagesobjects.EnterSearchValue("iphone 7 Black 32gb");

	    }
	 
	 @And("^Click on the Amazon first Item in the list$")
	 public void Click_on_the_Amazon_first_Item_in_the_list()throws Throwable{
		 
		 AmazonPagesobjects.ClickOnFirstItem();
		 
	 }
	 
	 @Then("^Add to Amazon Cart>>Print the price$")
	 public void Add_to_Amazon_Cart_Print_the_price()throws Throwable{
		 
		 AmazonPagesobjects.AddProductToTheCart();
		 
	 }
	 
	 @And("^Compare Both The Prices>>print Which site is giving Cheaper rates$")
	 public void Compare_Both_The_Prices_print_Which_site_is_giving_Cheaper_rates()throws Throwable{
		 AmazonPagesobjects.ComParePrices();
		 
		 
		 
	 }
	 		
	 
}
