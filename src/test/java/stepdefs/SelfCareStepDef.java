package stepdefs;



import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelfCareStepDef extends TestBase {


	@When("user dropdown the sortBy button")
	public void user_dropdown_the_sort_by_button() {
		homePage.SortByButton();
	}

	@When("user select the option {string}")
	public void user_select_the_option(String string) {
		System.out.println("user select the option {string}");
	}

	@When("user click the creamSerum link")
	public void user_click_the_cream_serum_link() {
		homePage.creamSerumLink();
	}

	@When("user click the add to cart  button")
	public void user_click_the_add_to_cart_button() {
		homePage.creamSerumAddButton();

	}

	@When("user select the cart button")
	public void user_select_the_cart_button() {
		homePage.CartButton();

	}

}
