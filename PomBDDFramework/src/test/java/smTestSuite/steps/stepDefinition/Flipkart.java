package smTestSuite.steps.stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objects.FlipkartPages;
import utility.TestBase;

public class Flipkart extends TestBase{

	FlipkartPages flipkartobjects ;
	
	 @Given("^open Browser$")
	 public void open_Browsers() throws Throwable
	 {
		 TestBase.OpenApplication();
		 flipkartobjects=new FlipkartPages(); 
		 
	 }
	
	 @And("^Enter FlipKart URL$")
	 public void Enter_Flipkart_URL()throws Throwable{
		 
		 String url="http://www.flipkart.com";
		 driver.get(url);
	 }
	 
	    @Then("^Enter UserName and Password$")
	    public void Enter_UserName_and_Password()throws Throwable{
	    	
	    	flipkartobjects.LoginToFilpkart("Emailaddress", "Password");
	    	
	    	
	    }
	    
	    @Then("^Enter Product name in searchTextbox$")
	    public void Enter_Product_name_in_searchTextbox() throws Throwable{
	    	
	    	flipkartobjects.SearchValue("Vu Smart Andriod Tv");
	    }
	
	    @And("^Click on the first Item in the list$")
	    public void Click_on_the_first_Item_in_the_list() throws Throwable{
	    	
	    	flipkartobjects.ClickOnFirstItem();
	    	
	    	
	    }
	
	    @Then("^Add to Cart Increase Quantity by 1>>print the Price after Addition of Quantity$")
	    public void Add_to_Cart_Increase_Quantity_by_1_print_the_Price_after_Addition_of_Quantity() throws Throwable{
	    	
	    	flipkartobjects.PrintTheFinalPriceAfterAddingProdcut();
	    	
	    }
	    
	    @Then("^Add to Cart>>Print the price$")
	    public void Add_to_Cart_Print_the_price() throws Throwable{
	    	flipkartobjects.AddProductToTheCart();
	    	//Thread.sleep(2000);
	    	
	    	
	    	
	    }
	    
	    @Then("^Close The Browser$")
	    public void Close_The_Browser()throws Throwable{
	    	
	    	//Thread.sleep(2000);
	    	driver.quit();
	    	System.out.println("------current browser got closed-----------");
	    	
	    	
	    }
	    
	    @Then("^Enter Second Product name in searchTextbox$")
	    public void Enter_Second_Product_name_in_searchTextbox() throws Throwable{
	    	
	    	flipkartobjects.SearchValue("iphone 7 Black 32gb");
	    }
}
