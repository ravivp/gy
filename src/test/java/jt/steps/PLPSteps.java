package jt.steps;

import core.context.Apps;
import core.data.globalVariable;
import core.datareader.json;
import core.utils.SearchContext;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class PLPSteps {

    SearchContext searchContext;
    public PLPSteps(SearchContext searchContext){
        this.searchContext=searchContext;
    }
    public Apps apps=new Apps();

    @Then("I verify search vehicle on PLP page")
    public void verifySearchedVehicleOnPLP(){


        System.out.println(apps.plpPage.verifySearchVehicleDetailsONPLP());
        Assert.assertEquals("Searched vehicle Tires not showing",

                json.getConvertedVehicleToList("vehicle"),
                apps.plpPage.verifySearchVehicleDetailsONPLP());
    }


    @Then("I click on add to cart on PLP page")
    public void addToCartOnPLP(){

        searchContext.setGlobalStore(globalVariable.tireName,apps.plpPage.getTireName());
        searchContext.setGlobalStore(globalVariable.productBadge,apps.plpPage.getProductBadge());
        apps.plpPage.addToCartOnPLP();
    }
}
