package jt.pages;

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

    @FindBy(css = "button[data-qa-id='pdp-in-store-tab']")
    private WebElement inStore;

    @FindBy(xpath= "//div[@data-qa-id='quick-view-add-to-cart-product']//button")
    private WebElement addToCarOnMiniCart;

    public void selectInStore(){
        Utilities.clickOnElement(inStore);
    }
    public void addToCartOnMiniCart(){
        Utilities.clickOnElement(addToCarOnMiniCart);
    }

}
