package jt.pages;

import core.utils.CustomException;
import core.utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private WebDriver driver;
   public Cart(WebDriver driver){

       this.driver=driver;
       PageFactory.initElements(driver,this);
   }

    @FindBy(css = "h1[data-qa-id='cart-title']")
    private WebElement cartHeader;

    // tires summary in cart page
    @FindBy(css = "h2[data-qa-id='cart-item-header']")
    private WebElement tireHeader;
    @FindBy(xpath = "(//span[@data-qa-id='notification-text'])[1]")
    private WebElement tiresFitSuccessMsg;
    @FindBy(xpath = "(//span[@data-qa-id='notification-text'])[1]/preceding-sibling::*")
    private WebElement tiresFitSuccessNotificationImg;
    @FindBy(css = "a[data-qa-id='product-card-product-name']")
    private WebElement tireName;
    @FindBy(css = "div[data-qa-id='cart-tags-container'] span")
    private WebElement tireBadge;
    @FindBy(css = "div[data-qa-id='cart-product-image']")
    private WebElement tireImage;
    @FindBy(css = "a[data-qa-id='product-card-product-name']")
    private WebElement productName;
    @FindBy(css = "span[data-qa-id='cart-tire-size']")
    private WebElement tireSizeDetails;
    @FindBy(css = "label[data-qa-id='select-quantity']")
    private WebElement quantityLabel;
    @FindBy(css = "button[data-qa-id='cart-update-quantity-minus']")
    private WebElement updateQuantityMinus;
    @FindBy(css = "button[data-qa-id='cart-update-quantity-add']")
    private WebElement updateQuantityAdd;
    @FindBy(css = "span[data-qa-id='cart-update-quantity-count'")
    private WebElement tireQuantityCount;
    @FindBy(css = "span[data-qa-id='product-price']")
    private WebElement pricePerEachTire;
    @FindBy(css = "div[data-qa-id='total-price']")
    private WebElement productTotalPrice;


    @FindBy(css = "div[data-qa-id='cart-delete-btn'] button[data-qa-id='cart-removeproducts-delete-btn']")
    private WebElement tireRemoveBtn;

    //alignmentServiceLabel;
    // add on services in cart page
    @FindBy(xpath = "//div[@data-qa-id='add-service-subtitle']")
    private WebElement addServiceLabel;


    @FindBy(xpath = "//label[starts-with(@data-qa-id,'lbl-211119')]")
    private WebElement firstServiceLabel;
    @FindBy(css = "span[data-qa-id='add-on-service-vehicle-add-on']")
    private WebElement firstServicePrice;
    // css = "input[data-qa-id='add-on-service-0']

    @FindBy(xpath = "//div[@data-qa-id='add-on-checkbox-container']//input[@data-qa-id='add-on-service-0']")
    private WebElement addOnService1;
    @FindBy(xpath = "//label[starts-with(@data-qa-id,'lbl-211122')]")
    private WebElement secondServiceLabel;
    @FindBy(xpath = "//span[@data-qa-id='add-on-service-tire-add-on-cost']")
    private WebElement secondServicePrice;
    @FindBy(xpath = "//input[contains(@data-qa-id, 'add-on-service-1')]")
    private WebElement addOnService2;




    public void CartHeader(){

        Utilities.verifyIsDisplayed(cartHeader);

    }

    public String verifySelectedTireName(){

        return tireName.getText().trim();
    }


   public boolean verifyProductDetailsOnCart(){

        Utilities.scrollElementIntoView(driver,tireName);
       List<Boolean> productDetails=new ArrayList<Boolean>();
       productDetails.add(tireHeader.isDisplayed());
       productDetails.add(tiresFitSuccessMsg.isDisplayed());
       productDetails.add(tiresFitSuccessNotificationImg.isDisplayed());
       productDetails.add(tireBadge.isDisplayed());
       productDetails.add(tireName.isDisplayed());
       productDetails.add(tireSizeDetails.isDisplayed());
       productDetails.add(quantityLabel.isDisplayed());
       productDetails.add(updateQuantityMinus.isDisplayed());
       productDetails.add(updateQuantityAdd.isDisplayed());
       productDetails.add(tireQuantityCount.isDisplayed());
       productDetails.add(pricePerEachTire.isDisplayed());
       productDetails.add(productTotalPrice.isDisplayed());
       productDetails.add(tireImage.isDisplayed());
       productDetails.add(tireRemoveBtn.isDisplayed());

     //  System.out.println(productDetails.stream().allMatch(p->!p==true));
//

      // System.out.println(productDetails.stream().allMatch(p->p));
       boolean value;
        value= !productDetails.contains(false);
       return value;
   }

   public boolean totalProductPrice(){

        int tireQuantity= Utilities.getIntValueFromString(tireQuantityCount);
        float perTirePrice= Utilities.getFloatValueFromString(pricePerEachTire);
        float totalPrice= Utilities.getFloatValueFromString(productTotalPrice);

        if(totalPrice==tireQuantity*perTirePrice){
          return  true;
        }else {
          return false;
        }
   }

   public boolean verifyProductBadge(String badge){

       return tireBadge.getText().trim().equals(badge);
   }

   public void verifySuccessTireFitMessage(){

   }

   public void verifyAddOnServices(){

      boolean add=  Utilities.elementIsPresent(addServiceLabel);

        if(add){

            addServiceLabel.isDisplayed();

        }

   }
   public void selectAddOnService(String addOnService){

       boolean serviceLabel=  Utilities.elementIsPresent(addServiceLabel);
       if(serviceLabel) {

           if(addOnService.equals(Utilities.getFirstIndexText(firstServiceLabel.getText().trim()))){

               Utilities.javaScriptExecutor(driver,addOnService1);
              // Utilities.elementToBeClickable(driver,addOnService1);

           } else if (addOnService.equals(Utilities.getFirstIndexText(secondServiceLabel.getText().trim()))) {

               Utilities.javaScriptExecutor(driver,addOnService2);
              // Utilities.elementToBeClickable(driver,addOnService2);

           } else {

               throw new CustomException(addOnService + " add on service not available");
           }

       }else {
           throw new CustomException("AddOn Service are not available for this tire");
       }

   }

   public List<Boolean> verifyAddOnService(String addOnService){

       // Utilities.scrollElementIntoView(driver, addServiceLabel);
       boolean serviceLabel=  Utilities.elementIsPresent(addServiceLabel);
        List<Boolean> serviceDetails=new ArrayList<>();

       if(serviceLabel){


          if(addOnService.equals(Utilities.getFirstIndexText(firstServiceLabel.getText().trim()))){

           serviceDetails.add(firstServiceLabel.isDisplayed());
           serviceDetails.add(firstServicePrice.isDisplayed());

          } else if (addOnService.equals(Utilities.getFirstIndexText(secondServiceLabel.getText().trim()))) {
             serviceDetails.add(secondServiceLabel.isDisplayed());
             serviceDetails.add(secondServicePrice.isDisplayed());
          }else {
              throw new CustomException(addOnService +" add on service not available");
           }
       }else {
           throw new CustomException("AddOn Service are not available for this tire");
       }

       return  serviceDetails;
   }

}
