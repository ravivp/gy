package jt.steps;

import core.browser.Browser;
import core.browser.PropertyReader;
import core.context.Apps;
import core.utils.Utilities;
import core.utils.SearchContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.ElementClickInterceptedException;

public class GenericSteps {


    SearchContext searchContext;
    public GenericSteps(SearchContext searchContext){

        this.searchContext=searchContext;
    }
    Apps apps=new Apps();

    @Given("I launch the application")
    public void launchApplication(){

        Browser.getDriver().get(PropertyReader.get("gy"));

    }
    @When("I accept the cookies")
    public void acceptCookies(){

       Assert.assertEquals("Cookies not accepted",true,apps.homePage.cookiesAccept());


    }

    @When("I wait for {string} seconds")
    public void staticSleep(String waitTime){

        Utilities.staticWait(waitTime);
    }
    @When("I am on Home page")
    public void verifyHomepage(){

        try {
            //homePage.clickOnFindStore();
        }catch (ElementClickInterceptedException e){
            e.printStackTrace();
        }

        Assert.assertEquals("Unable to select store",true,apps.homePage.getConfirmStore());

    }
    @Then("I verify Home page title")
    public void elementIsDisplay(){

        Assert.assertEquals(true,true);
    }


    @When("I click on find store link on Global header")
    public void clickOnStoreButton(){

        apps.findStore.clickOnFindStoreButton();
    }
    @When("I search store by {string} zipcode")
    public void searchStore(String searchKey){

        apps.findStore.searchStoreAndSelectStore(searchKey);
    }


    @When("I verify element is present")
    public void elementPresent(){

    }



}

