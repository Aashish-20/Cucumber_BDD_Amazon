package cucmberAmazon.test.amazon.StepDefinitions;



import cucmberAmazon.test.amazon.pages.LocationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LocationSteps {

	private LocationPage locationPage;
	
	
	@Given("I am on the Amazon home page")
    public void i_am_on_the_Amazon_home_page() {
		
        locationPage = new LocationPage(Hooks.getDriver());
        locationPage.navigateToHomePage();
    }
	
	@Given("I clicked on the update location")
	public void i_clicked_on_the_update_location() {
		locationPage.clickedLocationUpdateButton();
		
	}

	@When("I entered pincode {string}")
	public void i_entered_pincode(String pincode) {
		locationPage.enterPincode(pincode);
	}

	@Then("My location updated to {string}")
	public void my_location_updated_to(String pincode) {

		locationPage.isLocationUpdated(pincode);

		
	}

	@When("I entered the invalid pincode {string}")
	public void i_entered_the_invalid_pincode(String invalidPincode) {
		locationPage.enterPincode(invalidPincode);
	}

	@Then("location not get updated")
	public void location_not_get_updated() {

		locationPage.isUpdationFailed();
	}
	
}
