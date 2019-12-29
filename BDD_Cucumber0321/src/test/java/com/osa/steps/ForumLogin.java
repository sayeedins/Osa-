package com.osa.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.osa.base.Browser;
import com.osa.pages.ForumLoginPageFactory;
import com.osa.pages.HomePagesFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ForumLogin {
	HomePagesFactory hp;
	ForumLoginPageFactory fl;
	WebDriver dr;
	public static Logger log=Utility.getLog(ForumLogin.class);
	@Given("^I am on Forum login page$")
	public void i_am_on_Forum_login_page() throws Throwable {
	  dr=Browser.openBrowser();
	  log.info("Navitaging to https://www.osaconsultingtech.com");
	  dr.get("https://www.osaconsultingtech.com");
	  hp=new HomePagesFactory(dr);
	  log.info("Clicking on Forum login button");
	  hp.clickOnForumLoginButton();
	}

	@When("^I enter username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void i_enter_username_and_Password(String username, String password) throws Throwable {
		fl=new ForumLoginPageFactory(dr);
		fl.enterUserName(username);
		fl.enterPassword(password);
	}

	@Then("^I verify the login is successful$")
	public void i_verify_the_login_is_successful() throws Throwable {
	  log.info("Clicking on login button");
	  fl.clickOnLoginButton();
	  
	}
	@And("^I close the browser$")
	public void i_close_the_browser() throws InterruptedException {
		Thread.sleep(5000);
		log.info("Closing Browser");
		dr.close();
	}
}
