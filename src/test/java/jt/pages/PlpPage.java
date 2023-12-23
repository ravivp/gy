package jt.pages;

import core.utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PlpPage {

    private WebDriver driver;

    public PlpPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "h1[data-qa-id='search-results-heading']")
    private WebElement searchResultHeading;

    @FindBy(css = "div[data-qa-id='result-count'] span")
    private WebElement resultCount;
    @FindBy(xpath = "//a[@data-qa-id='product-card-product-name']")
    private List<WebElement> listOfTireLinks;

    @FindBy(xpath = "(//a[@data-qa-id='product-card-product-name'])[1]")
    private WebElement tireLink;
    @FindBy(xpath = "(//button[starts-with(@data-qa-id,'add-to-cart-btn')])[1]")
    private WebElement addToCart;
    ////Various components of tire
    @FindBy(xpath = "//a[@data-qa-id='product-card-image']")
    private WebElement tireImage;

    @FindBy(xpath = "(//a[@data-qa-id='product-card-product-name'])[1]//h3")
    private WebElement tireName;

    @FindBy(xpath = "(//div[starts-with(@data-qa-id,'product-card-container')])[1]//div[@data-qa-id='product-badges']//div")
    private WebElement productBadge;
    public List<String> verifySearchVehicleDetailsONPLP(){

        return Utilities.getSplitText(searchResultHeading);
    }

    public void verifyVariousComponentsOfTire(){

        String firstTire="(//div[starts-with(@data-qa-id,'product-card-container-')])[1]";
    }
    public void clickOnAddToCart(){
        Utilities.clickOnElement(addToCart);

    }
    public void addToCartOnPLP(){

        Utilities.clickOnElement(addToCart);
    }
    public String getTireName(){
       return tireName.getText().trim();
    }
    public String getProductBadge(){
        return Utilities.getText(productBadge);
    }
}
