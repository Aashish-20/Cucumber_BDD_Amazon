Feature: Login Feature
Background:
	Given I am in the Amazon home page
	

 @login @valid	
 Scenario Outline: Successful login
    When I login with username "<username>" and password "<password>"
    Then I should be logged in successfully
    
    Examples:
			|username|password|
			|user@test.com|123|
	@login @invalid	
  Scenario Outline: Failed login
    When I login with invalid username "<username>" and invalid password "<password>"
    Then I should see an error message
    
    Examples:
			|username|password|
			|user@.com|123|