Feature: Admin Product invalid features 

Scenario: Admin is on login page 
	Given Admin is on login page 
	When Admin enter valid AdminId and valid password 
	And click on login button 
	Then admin should get navigated to admin home page 
	
Scenario: Admin Searches for Product using invalid Product id 
	When Admin clicks on link search product by id 
	And On search product page enters the invalid product id 
	And click on search button 
	Then It should show the product ID error message 
	
Scenario: Admin Searches for Product using invalid Product name 
	When Admin clicks on link search product by name 
	And On search product page enters invalid product name 
	And click on search product button 
	Then It should show the product name error message 
	
Scenario: Admin is not able to Update a product info 
	When Admin clicks on change the details link 
	And inserts non existing id to update a particular product 
	And Click on update button 
	Then Admin clicks on get all product link to check the updated product 
          