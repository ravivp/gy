package jt.pages;

import core.utils.CustomException;
import core.utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MiniCart {

    private WebDriver driver;
    public MiniCart(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "button[data-qa-id='pdp-roll-installation-tab']")
    private WebElement roll;

    @FindBy(css = "button[data-qa-id='pdp-in-store-tab']")
    private WebElement inStore;

    @FindBy(xpath= "//div[@data-qa-id='quick-view-add-to-cart-product']//button")
    private WebElement addToCarOnMiniCart;

    public void selectServiceLocation(String serviceLocation){

        if(serviceLocation.equals("roll")){
            Utilities.clickOnElement(roll);
        }else if (serviceLocation.equals("inStore")){
            Utilities.clickOnElement(inStore);
        }else {
            throw new CustomException(serviceLocation+ " is not found");
        }

        Utilities.javaScript(driver,addToCarOnMiniCart);
    }
    public void addToCartOnMiniCart(){

        Utilities.javaScript(driver,addToCarOnMiniCart);

    }

}
