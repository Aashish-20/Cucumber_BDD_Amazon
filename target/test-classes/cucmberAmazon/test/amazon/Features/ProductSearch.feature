Feature: Product Search Feature

Background:
	Given I am on Amazon home page
	
	@product @valid
  Scenario Outline: Search for valid products
    When I search for "<product>"
    Then I should see the product details

  Examples:
    | product    |
    | laptop     |
    | headphones |
  @product @invalid
  Scenario Outline: Search for invalid products
    When I search for "<product>"
    Then I should see no products

  Examples:
    | product      |
    | ghjkj123!!   |
    

  