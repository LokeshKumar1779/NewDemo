package stepDefinitions;



import org.junit.runner.RunWith;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalHomePage;
import resources.base;

@RunWith(Cucumber.class)
public class stepDefinition extends base{
	
	LoginPage lp;

@Given("^Initialize browser with chrome$")
    public void initialize_browser_with_chrome() throws Throwable {
			driver = initializeDriver();
    }


@And("^Navigate to \"([^\"]*)\" site page$")
public void navigate_to_something_site_page(String strArg1) throws Throwable {
	driver.get(strArg1);
}


@And("^Click on login link on home page to land on secure sign in page$")
public void click_on_login_link_on_home_page_to_land_on_secure_sign_in_page() throws Throwable {
	LandingPage l=new LandingPage(driver);
	if (l.getPopUpSize()>0) {
		l.getPopUp().click();
	}
	
	 lp=l.getLogin();
	
}

  
    @Then("^Verify that user is successfully logged in$")
    public void verify_that_user_is_successfully_logged_in() throws Throwable {
        
    	PortalHomePage p = new PortalHomePage(driver);
    	Assert.assertTrue(p.getSearchBox().isDisplayed());
    }
    
    @When("^user enters (.+) and (.+) and logs in$")
    public void user_enters_test99_gmail_com_and_and_logs_in(String username, String password) {
     
     		lp.getEmail().sendKeys(username);
    		lp.getPassword().sendKeys(password);
    		lp.getLogin().click();
    }
    
    @And("^close browsers$")
    public void close_browsers() throws Throwable {
        driver.quit();
    }


  
}