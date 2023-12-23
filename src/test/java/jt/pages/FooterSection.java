package jt.pages;

import core.utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FooterSection {


   private WebDriver driver;
    public FooterSection(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[starts-with(@class,'footer-logo')]//img")
    private WebElement footerLogo;
    @FindBy(css = "div[data-qa-id='footer-column-1'] a")
    private List<WebElement> companyList;

    @FindBy(xpath = "//h3[text()='company']")
    private WebElement companyLabel;
    @FindBy(xpath = "//h3[text()='owners']")
    private WebElement ownersLabel;
    @FindBy(css = "ul#collapsible-owners a")
    private List<WebElement> ownersList;
    @FindBy(xpath = "//h3[text()='support']")
    private WebElement supportLabel;
    @FindBy(css = "ul#collapsible-about a")
    private List<WebElement> supportList;

    @FindBy(xpath = "//h3[@class='title']")
    private WebElement talkUsLabel;

    @FindBy(css = "h2[data-qa-id='title-emailsignup']")
    private WebElement emailSignup;

   public boolean verifyAnyCompanyLinkBroken(){

       HashMap<String, Integer> brokenLinks = (HashMap<String, Integer>) Utilities.verifyLink(companyList);
       if(!brokenLinks.containsValue(200)){
           brokenLinks.entrySet().forEach(stringIntegerEntry -> {
                   System.out.println(stringIntegerEntry.getKey());
                   System.out.println(stringIntegerEntry.getValue());
                  });
           return false;
       }else {
           return true;
       }

   }

    public boolean verifyAnyOwnersLinkBroken(){


        HashMap<String, Integer> brokenLinks = (HashMap<String, Integer>) Utilities.verifyLink(ownersList);
        if(!brokenLinks.containsValue(200)){
            brokenLinks.entrySet().forEach(stringIntegerEntry -> {
                System.out.println(stringIntegerEntry.getKey());
                System.out.println(stringIntegerEntry.getValue());
            });
            return false;
        }else {
            return true;
        }

    }

    public boolean verifyAnySupportLinkBroken(){


        HashMap<String, Integer> brokenLinks = (HashMap<String, Integer>) Utilities.verifyLink(supportList);
        if(!brokenLinks.containsValue(200)){
            brokenLinks.entrySet().forEach(stringIntegerEntry -> {
                System.out.println(stringIntegerEntry.getKey());
                System.out.println(stringIntegerEntry.getValue());
            });
            return false;
        }else {
            return true;
        }

    }


   public List<String> companyNameInFooterSection(){

      return Utilities.getText(companyList);
       //return companyList.stream().map(companyName->companyName.getText().trim()).collect(Collectors.toList());
   }

   public List<String> ownersNameInFooterSection(){

       return  Utilities.getText(ownersList);

   }

    public List<String> supportNameInFooterSection(){

       return  Utilities.getText(supportList);

    }

   public List<String> footerHeader(){

       List<String> headerText=new ArrayList<>();
       headerText.add(companyLabel.getText());
       headerText.add(ownersLabel.getText());
       headerText.add(supportLabel.getText());
       headerText.add(talkUsLabel.getText());

       return headerText;
  }


   public void footerGoodyearLogo(){
       Utilities.scrollElementIntoView(driver,footerLogo);

   }
   public boolean emailSignupTitleInFooter(){
       Utilities.scrollElementIntoView(driver,emailSignup);
     return Utilities.elementIsPresent(emailSignup);
   }

}
