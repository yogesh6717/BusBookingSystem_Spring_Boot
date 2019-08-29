Feature: Admin login feature 

Scenario: Admin login with valid credential 
	Given Admin is on login page 
	When Admin enter valid AdminId and valid password 
	And click on login button 
	Then admin should get navigated to admin home page 
	
	
Scenario: Admin Searches for Product using Product name 
	When Admin clicks on link search product by name 
	And On search product page enters the product name 
	And click on search product button 
	Then It should show the product for that name 
	
Scenario: Admin searches for Product using Product id 
	When Admin clicks on link search product by id 
	And On search product page enters the product id 
	And click on search product button 
	Then It should show the product of that id 
	
	
Scenario: Admin get all customers 
	When Admin clicks on link Get All Customers 
	Then It should show all the list of Customers with details 
	And If we want to remove the user then click on remove button 
	
Scenario: Admin Searches for All the Product 
	When Admin clicks on get all product link 
	Then It should show all the product 
	
	
Scenario: Admin Can Add new Product Info 
	When Admin clicks on add product link 
	And Admin Adds all the product Info 
	And Admin then Clicks on add product button 
	Then Admin clicks on get all product link 
	
Scenario: Admin can Update a product info 
	When Admin clicks on update product link 
	And Add info to update a particular product 
	And Click on update button 
	Then Admin clicks on get all product link 
	
Scenario: Admin can remove the product from the get all product list 
	When Admin clicks on get all product link 
	Then It should show all the product 
	When Admin clicks on remove button for a particular product 
	Then The product info should get removed 
	
	
	
	
	
