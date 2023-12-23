package jt.steps;

import core.context.Apps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MiniCartSteps {

    public Apps apps=new Apps();

    @Then("I select inStore on Mini Cart")
    public void selectInStoreOnMiniCart(){

        apps.miniCart.selectInStore();
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
