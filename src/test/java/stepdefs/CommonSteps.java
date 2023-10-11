package stepdefs;

import java.util.List;
import java.util.Map;

import base.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import reports.Loggers;


public class CommonSteps extends TestBase {//common steps in both test class
	@Given("the costco titlePage'Welcome to Costco Wholesale'")
	public void the_costco_title_page_welcome_to_costco_wholesale() {
		homePage.titleText(getDriver(), "Welcome to Costco Wholesale");
	}

	@When("user scroll down the page")
	public void user_scroll_down_the_page() {
		homePage.scrollDownTest(getDriver());

	}

	@Then("verify costco footerMessage {string}")
	public void verify_costco_footer_message(String string) {
		homePage.verifyCostcoFooterText(string);
	}

	@When("user scrolls Up the homepage")
	public void user_scrolls_up_the_homepage() {
		homePage.scrollUpTest(getDriver());
	}

	@When("user input in searchField {string}")
	public void user_input_in_search_field(String string) {
		homePage.inputSearchField(string);
		// Assert.fail();
	}
	@When("user input in searchField <searchField>")
	public void user_input_in_search_field(DataTable table) {
		List<String> searchFields = table.asList();//taking list of strings from the table created 
		for(String searchField : searchFields) {//reading searchFieldS list one by one in searchField space!!
		homePage.inputSearchField(searchField);//whatever is taken from lists here it will input using input method and search one by one
		// Assert.fail();
		}
	}

	
	@When("user click searchField button")
	public void user_click_search_field_button() {
		homePage.clickSearchButton();
	}
	
	
	@Given("print <msg>")
	public void printMsg(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    
		Map<String, String> map = dataTable.asMap();
		for(Map.Entry<String, String> entry : map.entrySet()) {
		Loggers.log(entry.getKey());
		}
}
}