package cucmberAmazon.test.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import cucmberAmazon.test.amazon.waits.Waits;


public class LoginPage  {
	
	private WebDriver driver;
	
	private Waits waits = new Waits();
	
	@FindBy(id = "nav-logo-sprites")
	WebElement logo;

	@FindBy(id = "ap_email")
	private WebElement emailInput;

	@FindBy(id = "ap_password")
	private WebElement passwordInput;
	
	@FindBy(css = "h4[class=\"a-alert-heading\"]")
	private WebElement errorBox;

	@FindBy(id = "signInSubmit")
	private WebElement signInButton;

	@FindBy(id = "auth-error-message-box")
	private WebElement errorMessage;

	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	private WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToHomePage() {
	
		//waiting for the amazon icon to be loaded
		waits.waitForVisibility(driver, logo);
		Assert.assertTrue(logo.isDisplayed());
	}

	public void enterEmail(String email) {
		emailInput.sendKeys(email);
		
		//continue after entering the username
		continueButton();

	}
	
	public void clickLoginBtn() {
		loginBtn.click();

	}

	public void continueButton() {
		continueBtn.click();
	}

	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public void clickSignInButton() {
		signInButton.click();
	}
	
	public boolean isUserLoggedIn() {
		
		//checks that user is logged in or not
		
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Authentication required");
        return pageTitle.equals("Authentication required");
    }

    public void isErrorMessageDisplayed() {
		
		waits.waitForVisibility(driver, errorBox);
		Assert.assertTrue(errorBox.isDisplayed());
		
    }
}