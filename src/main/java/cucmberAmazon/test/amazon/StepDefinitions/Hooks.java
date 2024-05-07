package cucmberAmazon.test.amazon.StepDefinitions;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks  {
	public static WebDriver driver; 
	
	//launching the browser window
	@Before
	public void initial() {
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
	}
	
	//quitting the browser window
	@After
	public void cleanUp() {
		driver.quit();
	}
	
	//returning the instance of the webdriver
	public static WebDriver getDriver() {
		return driver;
	}
}