package steps;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;
import utils.LoggerUtils;

public class DistrictStep extends BaseClass{
	private static HomePage home;
	private static SearchPage search;
	
	
	@Given("I am on the District.in home page")
	public void I_am_on_the_District_in_home_page() {
		home = new HomePage(driver);
		LoggerUtils.info("I am on the District.in home page");
	}
	
	@When("I click on the Search icon")
	public void I_click_on_the_Search_icon() {
		home.clickSearch();
		LoggerUtils.info("I clicked on the Search icon");
	}

	@And("I click on the Movies link")
	public void I_click_on_the_Movies_link() {
		search = new SearchPage(driver);
		search.clickMovies();
		LoggerUtils.info("I clicked on the Movies link");
	}
	
	@And("I enter {value} in the search box")
	public void I_enter_in_the_search_box(String value) {
		search.enterTextToSearch(value);
		LoggerUtils.info("I entered " + value + " in the search box");
	}
	
	@Then("I should see the search results for {value}")
	public void I_should_see_the_search_results_for(String value) {
		Assert.assertTrue(search.getSearchResult().trim().contains(value));
		LoggerUtils.pass("Search Result is showing the correct Movie details");
	}
}
