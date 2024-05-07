package cucmberAmazon.test.amazon.StepDefinitions;

import cucmberAmazon.test.amazon.pages.ProductSearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class ProductSearchtSteps  {
	
	private ProductSearchPage searchResultPage;


	@Given("I am on Amazon home page")
	public void i_am_on_Amazon_home_page() {
	
		searchResultPage = new ProductSearchPage(Hooks.getDriver());
		searchResultPage.navigateToHomePage();
	}

	@When("I search for {string}")
	public void i_search_for(String searchTerm) {
		searchResultPage.searchForProduct(searchTerm);
	}

	@Then("I should see the product details")
	public void i_should_see_the_product_details() {
		searchResultPage.verifySearchResultsDisplayed();
	}

	@Then("I should see no products")
	public void i_should_see_no_products() {

		searchResultPage.isErrorMessageDisplayed();
	}
	


}