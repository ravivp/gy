package jt.steps;

import core.context.Apps;
import core.data.globalVariable;
import core.datareader.json;
import core.utils.SearchContext;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CartSteps {


    SearchContext searchContext;
    public CartSteps(SearchContext searchContext){
        this.searchContext=searchContext;
    }
    public Apps apps=new Apps();

    @Then("I verify selected tire on cart page")
    public void verifySelectedTireOnCart(){
        apps.cart.verifySelectedTireName();
        Assert.assertEquals("Verify selected tire on cart page",
                searchContext.getGlobalStore(globalVariable.tireName),
                apps.cart.verifySelectedTireName());

    }
    @Then("I verify product details in cart page")
    public void verifyProductDetails(){

        Assert.assertTrue("Verified product details in cart page",
                apps.cart.verifyProductDetailsOnCart());
    }

    @Then("I valid product Badge in cart page" )
    public void validateProductBadge(){
        Assert.assertTrue("Verify selected tire badge in cart page",
        apps.cart.verifyProductBadge((String) searchContext.getGlobalStore(globalVariable.productBadge)));
    }
    @Then("I just verify total price of tire In cart page")
    public void totalTirePriceInCart(){
        Assert.assertTrue("verify total price of tire in cart page",
                apps.cart.totalProductPrice());
    }

    @Then("I verify installation in cart")
    public void validatedInStoreInstallation(String installationOption){


    }
    @Then("I verify {string} add on service in cart")
    public void verifyAddOnService(String addONService){
        String service= (String) json.getValue(addONService);
       Assert.assertFalse("Verify addOn service details",
        apps.cart.verifyAddOnService(service).contains(false));
    }

    @Then("I add {string} service in cart")
    public void selectAddOnService(String selectService){

        String service= (String) json.getValue(selectService);
        apps.cart.selectAddOnService(service);

    }



}
