package step_definitions;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import implementation.Checkout;
import static org.junit.Assert.*;

public class CheckoutSteps {
	
	Checkout checkout = new Checkout();
	int bananaPrice = 0;
	int applePrice = 0;
	
	@Given("^the price of a \"([^\"]*)\" is (\\d+)p$")
	public void thePriceOfAIsP(String name, int price) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (name.equals("banana")) {
				bananaPrice = price;
		}
		else {
			applePrice = price;
		}
	}

	
	@When("^I checkout (\\d+) \"([^\"]*)\"$")
	public void iCheckout(int itemCount, String itemName) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (itemName.equals("banana")) {
			checkout.add(itemCount, bananaPrice);
		}
		else {
			checkout.add(itemCount, applePrice);
		}
		
	}

	@Then("^the total price should be (\\d+)p$")
	public void theTotalPriceShouldBeP(int total) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(total, checkout.total());
	}
}