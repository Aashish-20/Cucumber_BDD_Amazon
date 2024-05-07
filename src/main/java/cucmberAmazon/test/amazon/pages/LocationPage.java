package cucmberAmazon.test.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import cucmberAmazon.test.amazon.waits.Waits;

public class LocationPage {

	private WebDriver driver;
	
	private Waits waits = new Waits();
	
	@FindBy(id = "glow-ingress-line2")
	WebElement updateLocationButton;

	@FindBy(xpath = "//input[@id='GLUXZipUpdateInput']")
	WebElement pincode;

	@FindBy(id = "nav-logo-sprites")
	WebElement logo;

	@FindBy(id = "GLUXZipUpdate")
	WebElement applyButton;

	@FindBy(xpath = "//div[contains(text(),'Please enter a valid pincode')]")
	WebElement errorMessage;

	public LocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToHomePage() {
		//waiting for the amazon icon to be loaded
		waits.waitForVisibility(driver, logo);
		Assert.assertTrue(logo.isDisplayed());
	}

	public void clickedLocationUpdateButton() {
		//click the delivery location for updating the pincode
		updateLocationButton.click();
	}

	public void enterPincode(String pincodeInput) {
		
		waits.waitForVisibility(driver, pincode);
		pincode.sendKeys(pincodeInput);
		applyButton.click();
	}

	public void isLocationUpdated(String pincode) {
		
		//wait for the location to be updated
		waits.waitForTextToBePresent(driver, updateLocationButton, pincode);
	
		//checks that pincode is updated or not
		String pincodeTitle = updateLocationButton.getText();
		Assert.assertTrue(pincodeTitle.contains(String.valueOf(pincode)));
	}

	public void isUpdationFailed() {
		//checks that pincode is updated or not
		waits.waitForVisibility(driver, errorMessage);
		Assert.assertTrue(errorMessage.isDisplayed());
	}
}
