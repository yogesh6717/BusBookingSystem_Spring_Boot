@sprint1 
Feature: Admin feature 

Background: 
	Given Admin is on login page 
	
	
Scenario: Admin login with invalid credential 
	When Admin enter invalid AdminId and invalid password 
	And click on login button 
	Then admin should get the error message 
	
Scenario: Admin login with valid credential 
	When Admin enter valid AdminId and valid password 
	And click on login button 
	Then admin should get navigated to admin home page 
	
    