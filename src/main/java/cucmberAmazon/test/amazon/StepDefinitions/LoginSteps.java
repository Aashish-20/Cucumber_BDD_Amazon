package cucmberAmazon.test.amazon.StepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertTrue;

import cucmberAmazon.test.amazon.pages.LoginPage;


public class LoginSteps  {
	
    private LoginPage loginPage;
    
  
    @Given("I am in the Amazon home page")
    public void i_am_in_the_Amazon_home_page() {
        loginPage = new LoginPage(Hooks.getDriver());
        loginPage.navigateToHomePage();
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {

    	loginPage.clickLoginBtn();
    	loginPage.enterEmail(username);
        loginPage.enterPassword(password);
        loginPage.clickSignInButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        assertTrue(loginPage.isUserLoggedIn());
    }

    @When("I login with invalid username {string} and invalid password {string}")
    public void i_login_with_invalid_username_and_invalid_password(String invalidUsername, String invalidPassword) {

    	loginPage.clickLoginBtn();
        loginPage.enterEmail(invalidUsername);
        loginPage.isErrorMessageDisplayed();
 
        
    }
    
    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        loginPage.isErrorMessageDisplayed();
    }
 
}
