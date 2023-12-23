package jt.steps;

import core.context.Apps;
import io.cucumber.java.en.Then;


public class FindStoreSteps {

    public Apps apps=new Apps();


    @Then("I verify cart header on cart page")
    public void verifyCartPageHeader(){

        apps.cart.CartHeader();
    }
}
