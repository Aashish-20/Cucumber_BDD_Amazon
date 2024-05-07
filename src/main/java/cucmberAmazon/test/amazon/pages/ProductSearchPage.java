package cucmberAmazon.test.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import cucmberAmazon.test.amazon.waits.Waits;




public class ProductSearchPage {
	private WebDriver driver;
	
	private Waits waits = new Waits();
	
	@FindBy(xpath =  "//div[@data-component-type='s-search-result']")
	WebElement searchResults;
	
	@FindBy(id = "nav-logo-sprites")
	WebElement logo;
	
	@FindBy(xpath = "//input[@value='Go']")
	WebElement searchButton;
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;;
	
	@FindBy(className="sg-col-inner")
    WebElement errorMessage;
	

	public ProductSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToHomePage() {
		//waiting for the amazon icon to be loaded
		waits.waitForVisibility(driver, logo);
		Assert.assertTrue(logo.isDisplayed());
	}

	public void searchForProduct(String searchTerm) {
		
		//searches for the product
		searchBox.sendKeys(searchTerm);
		searchButton.click();
	}

	public boolean areSearchResultsDisplayed() {
		//checks for the search displayed or not
		
		waits.waitForVisibility(driver, searchResults);
		boolean searchResultsDisplayed = searchResults.isDisplayed();
		Assert.assertTrue(searchResultsDisplayed, "search results not displayed");
		return searchResultsDisplayed;
		
	}

	public void verifySearchResultsDisplayed() {
		
		boolean resultsDisplayed = areSearchResultsDisplayed();
		
		Assert.assertTrue(resultsDisplayed, "search results are not displayed.");
		
	}
	
	public void isErrorMessageDisplayed() {
		  String text=errorMessage.getText();
		  Assert.assertTrue(text.contains("No results"), "error msg does not contain NO RESULTS");
	  }

}
