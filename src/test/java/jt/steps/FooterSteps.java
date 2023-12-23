package jt.steps;

import core.context.Apps;
import core.datareader.json;
import core.utils.SearchContext;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class FooterSteps {

    SearchContext searchContext;
    public FooterSteps(SearchContext searchContext){
        this.searchContext=searchContext;
    }

    Apps apps=new Apps();

    @Then("I verify footer logo")
    public void verifyGlobalFooterLogo(){
        apps.footerSection.footerGoodyearLogo();
    }
    @Then("I just valid emil signUp title in footer")
    public void verifyEmailSignupInFooter(){
        Assert.assertTrue("Verify email signup title in footer",
                apps.footerSection.emailSignupTitleInFooter());
    }
    @Then("I valid Company links in footer section")
    public void findCompanyLinksBroken(){
        Assert.assertTrue("Company links are broken in footer section",
                apps.footerSection.verifyAnyCompanyLinkBroken());
    }
    @Then("I valid Owners links in footer section")
    public void findOwnersLinksBroken(){
        Assert.assertTrue("Owners links are broken in footer section",
                apps.footerSection.verifyAnyOwnersLinkBroken());
    }
    @Then("I valid Support links in footer section")
    public void findSupportLinksBroken(){
        Assert.assertTrue("Support links are broken in footer section",
                apps.footerSection.verifyAnySupportLinkBroken());
    }


   @Then("I verify footer headers")
    public void verifyFooterHeaders(){

        Assert.assertEquals("Verify global headers name in footer section",
                json.jsonArray("footerHeader") ,
                apps.footerSection.footerHeader());
   }

   @Then("I verify company name in footer")
    public void verifyCompanyNameInFooter(){
        Assert.assertEquals("Verify company name in footer section ",
                json.jsonArray("company"),
                apps.footerSection.companyNameInFooterSection());

   }
    @Then("I verify owners name in footer")
    public void verifyOwnersNameInFooter(){
        Assert.assertEquals("Verify Owners name in footer section ",
                json.jsonArray("owner"),
                apps.footerSection.ownersNameInFooterSection());

    }

    @Then("I verify support name in footer")
    public void verifySupportNameInFooter(){
        Assert.assertEquals("Verify support name in footer section ",
                json.jsonArray("support"),
                apps.footerSection.supportNameInFooterSection());

    }
}
