Feature: Check locations pincode

Background:
	Given I am on the Amazon home page

		@pincode @valid
    Scenario Outline: valid pincodes
    And I clicked on the update location
    When I entered pincode "<pincode>"
    Then My location updated to "<pincode>"
    
    Examples:
      | pincode	|      
      | 226008  |
      
    @pincode @invalid
    Scenario Outline: Invalid pincodes
    And I clicked on the update location
    When I entered the invalid pincode "<pincode>"
    Then location not get updated    
    
    Examples:
      | pincode	|      
      | 2345ty  |