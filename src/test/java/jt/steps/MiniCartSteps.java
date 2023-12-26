package jt.steps;

import core.context.Apps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MiniCartSteps {

    public Apps apps=new Apps();

    @When("I select {string} installer Mini Cart")
    public void selectServiceLocationOnMiniCart(String selectLocation){

        apps.miniCart.selectServiceLocation(selectLocation);
    }
    @Then("I click on add to cart on Mini Cart")
    public void addToCartOnMiniCart(){

        apps.miniCart.addToCartOnMiniCart();
    }

    @When("I click on Select Store from find store")
    public void selectStoreFromFindStore(){

        apps.findStore.selectStoreFromFindStore();
    }
}
