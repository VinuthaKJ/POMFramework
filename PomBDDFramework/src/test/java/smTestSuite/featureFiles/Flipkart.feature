@SmokeTest
Feature: Flipkart module

	
  Scenario: First Sceanrio_Print the Price After Addition of Quantity
    Given open Browser
    And Enter FlipKart URL
    Then Enter UserName and Password
	Then Enter Product name in searchTextbox
	And Click on the first Item in the list
	Then Add to Cart Increase Quantity by 1>>print the Price after Addition of Quantity
    Then Close The Browser
	
	
	Scenario: SecondScenario_ComPare Price
    Given open Browser
    And Enter FlipKart URL
    Then Enter UserName and Password
	Then Enter Second Product name in searchTextbox
	And Click on the first Item in the list
	Then Add to Cart>>Print the price
	Then Close The Browser
	
	 Given open Chrome Browser
	 And Enter Amazon URL
	 Then Enter Amzon Product name in searchTextbox
	And Click on the Amazon first Item in the list
	Then Add to Amazon Cart>>Print the price
	And Compare Both The Prices>>print Which site is giving Cheaper rates
	Then Close The Browser 
	
	 
	
	