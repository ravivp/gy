package jt.pages;

import core.utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;
    public HomePage(WebDriver driver){
      this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath ="//button[text()='Accept All Cookies']")
    private WebElement acceptCookies;
    @FindBy(xpath = "(//a[@data-qa-id='unknown-location-confirm-store-link'])[2]")
    private WebElement confirmStore;



    public boolean cookiesAccept(){

        return Utilities.clickOnElement(acceptCookies);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public boolean getConfirmStore(){

        return Utilities.clickOnElement(confirmStore);
    }


}
