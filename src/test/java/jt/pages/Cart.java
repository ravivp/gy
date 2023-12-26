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

   // installer


    @FindBy(xpath = "//button[@data-qa-id='cart-roll-installation-tab' and contains(@class,'selected')]")
    private WebElement mobileInstallationSelected;
    @FindBy(css = "span[data-qa-id='roll-mobile-installation']")
    private WebElement mobileInstallationLabel;
    @FindBy(css = "button[data-qa-id='cart-roll-installation-tab'] svg[data-qa-id='selector-card-header-img']")
    private WebElement mobileInstallationVan;
    @FindBy(css = "button[data-qa-id='cart-in-store-tab'] svg[data-qa-id='selector-card-header-img']")
    private WebElement inStoreInstallationImg;


    // css= button[data-qa-id='cart-in-store-tab'][class*='selected']
    @FindBy(xpath = "//button[@data-qa-id='cart-in-store-tab' and contains(@class,'selected')]")
    private WebElement instoreInstallationSelected;
    @FindBy(css = "span[data-qa-id='instore-installation']")
    private WebElement instoreInstallationLabel;

    @FindBy(css = "span[data-qa-id='store-name']")
    private WebElement storeName;



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

    //div[@data-qa-id='add-on-checkbox-container']//input[@data-qa-id='add-on-service-0']
    // css= div[data-qa-id='add-on-checkbox-container']
    @FindBy(css = "input[data-qa-id='add-on-service-0']")
    private WebElement addOnService1;
    @FindBy(xpath = "//label[starts-with(@data-qa-id,'lbl-211122')]")
    private WebElement secondServiceLabel;
    @FindBy(xpath = "//span[@data-qa-id='add-on-service-tire-add-on-cost']")
    private WebElement secondServicePrice;

    //input[contains(@data-qa-id, 'add-on-service-1')]

    @FindBy(css = ".custom-control.custom-checkbox.d-flex")
    private WebElement addOnService2;


    // order summary details in cart page

    @FindBy(css = "h2[data-qa-id='checkout-order-summary-heading']")
    private WebElement orderSummaryHeading;
    @FindBy(css = "div[data-qa-id='cart-order-summary-subtotal-title'] span")
    private WebElement subtotalTitle;
    @FindBy(css = "div[data-qa-id='cart-order-summary-subtotal'] span")
    private WebElement subtotalPrice;

    @FindBy(xpath = "(//div[@data-qa-id='cart-order-summary-installation-title']//button)[1]")
    private WebElement installationTitle;
    @FindBy(css = "div[data-qa-id='cart-order-summary-installation'] span.installation-total")
    private WebElement installationPrice;
    @FindBy(css = "div[data-qa-id='cart-order-summary-tax-items'] button")
    private WebElement summaryTaxItemsLabel;
    @FindBy(css = "span[data-qa-id='sales-tax-total']")
    private WebElement salesTaxTotal;

    @FindBy(css = "div[data-qa-id='cart-order-summary-total-title'] p")
    private WebElement summaryTotalTitle;
    @FindBy(css = "p[data-qa-id='cart-grand-total']")
    private WebElement summaryTotalPrice;
    @FindBy(xpath = "(//div[@data-qa-id='cart-order-summary-subtotal-title']//span)[2]")
    private WebElement rollMobileServiceLabel;
    @FindBy(css = "span[data-qa-id='roll-mobile-total']")
    private WebElement rollMobileServiceFees;




    //checkout button

    @FindBy(css = "button[data-qa-id='checkout-btn']")
    private WebElement checkoutBtn;


    public boolean selectServiceLocation(String installation){

        boolean flag=false;
        switch (installation){


            case "roll":
                mobileInstallationSelected.isDisplayed();
                flag=verifyRollMobileSelectService();
                break;
            case "inStore":
                instoreInstallationSelected.isDisplayed();

                flag=flag=verifyInStoreSelectService();
                break;
            case "default":
            throw new CustomException(" this "+installation+ " Service not providing ");
        }
       return flag;

    }
    public boolean verifyInStoreSelectService(){

        List<Boolean> inStoreService=new ArrayList<>();

        inStoreService.add(instoreInstallationLabel.isDisplayed());
        inStoreService.add(inStoreInstallationImg.isDisplayed());
        inStoreService.add(storeName.isDisplayed());
        return inStoreService.stream().allMatch(value->value==true);

    }

    public boolean verifyRollMobileSelectService(){
        List<Boolean> rollMobile=new ArrayList<>();
        rollMobile.add(mobileInstallationVan.isDisplayed());
        rollMobile.add(mobileInstallationLabel.isDisplayed());

        return rollMobile.stream().allMatch(roll->roll==true);
    }

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

      return productDetails.stream().allMatch(p->p==true);
//

      // System.out.println(productDetails.stream().allMatch(p->p));
//       boolean value;
//        value= !productDetails.contains(false);
//       return value;
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
   public boolean selectAddOnService(String addOnService) throws InterruptedException {

       boolean serviceLabel=  Utilities.elementIsPresent(addServiceLabel);
       float service1=0;
       float service2=0;
       boolean flag=false;
       if(serviceLabel) {

           if( Utilities.elementIsPresent(firstServiceLabel)){
               if(addOnService.equals(Utilities.getFirstIndexText(firstServiceLabel.getText().trim()))) {

                   service1 = Utilities.getFloatValueFromString(firstServicePrice);
                   Utilities.scrollElementIntoView(driver,subtotalPrice);

                   float subTotalFee = Utilities.getFloatValueFromString(subtotalPrice);



                   Utilities.scrollElementIntoView(driver,addOnService1);

                   Utilities.javaScriptExecutor(driver, addOnService1);

                   Utilities.scrollElementIntoView(driver,subtotalPrice);

                   float subTotalAfterAddingService = Utilities.getFloatValueFromString(subtotalPrice);

                   if (subTotalAfterAddingService == service1 + subTotalFee) {
                       flag = true;
                   }
               }

           } else if (addOnService.equals(Utilities.getFirstIndexText(secondServiceLabel.getText().trim()))) {

               service2=Utilities.getFloatValueFromString(secondServicePrice);

               Utilities.scrollElementIntoView(driver,subtotalPrice);
               float subTotalFee=Utilities.getFloatValueFromString(subtotalPrice);

               if(Utilities.elementIsPresent(addOnService2)) {

                   Utilities.javaScriptExecutor(driver, addOnService2);

               }else{


                   Utilities.javaScriptExecutor(driver, addOnService1);

               }
               Utilities.scrollElementIntoView(driver,subtotalPrice);
               float  subTotalAfterAddingService=Utilities.getFloatValueFromString(subtotalPrice);
               if(subTotalAfterAddingService==service2+subTotalFee){
                   flag=true;
               }


           } else {

               throw new CustomException(addOnService + " add on service not available");
           }

       }else {
           throw new CustomException("AddOn Service are not available for this tire");
       }

       return flag;
   }

   public boolean verifyAddOnService(String addOnService){

       // Utilities.scrollElementIntoView(driver, addServiceLabel);
       boolean serviceLabel=  Utilities.elementIsPresent(addServiceLabel);
        List<Boolean> serviceDetails=new ArrayList<>();

       if(serviceLabel){


          if( Utilities.elementIsPresent(firstServiceLabel)){
              if(addOnService.equals(Utilities.getFirstIndexText(firstServiceLabel.getText().trim()))){
                  serviceDetails.add(firstServiceLabel.isDisplayed());
                  serviceDetails.add(firstServicePrice.isDisplayed());
              }

          } else if (addOnService.equals(Utilities.getFirstIndexText(secondServiceLabel.getText().trim()))) {
             serviceDetails.add(secondServiceLabel.isDisplayed());
             serviceDetails.add(secondServicePrice.isDisplayed());
          }else {
              throw new CustomException(addOnService +" add on service not available");
           }
       }else {
           throw new CustomException("AddOn Service are not available for this tire");
       }

       return  serviceDetails.stream().allMatch(value->value==true);
   }

   public boolean verifyOderSummary(){

       List<Boolean> orderSummaryStatus=new ArrayList<>();
       orderSummaryStatus.add(orderSummaryHeading.isDisplayed());
       orderSummaryStatus.add(subtotalTitle.isDisplayed());
       orderSummaryStatus.add(installationTitle.isDisplayed());
       orderSummaryStatus.add(summaryTaxItemsLabel.isDisplayed());
       orderSummaryStatus.add(summaryTotalTitle.isDisplayed());

       float rollInstallFee = 0;
       float subTotalPrice=Utilities.getFloatValueFromString(subtotalPrice);
       float installPrice=Utilities.getFloatValueFromString(installationPrice);
       float taxPrice=Utilities.getFloatValueFromString(salesTaxTotal);
       if(Utilities.elementIsPresent(rollMobileServiceLabel)){
           rollInstallFee=Utilities.getFloatValueFromString(rollMobileServiceFees);
       }
       float estimateTotal=Utilities.getFloatValueFromString(summaryTotalPrice);
       float overallSubTotal=subTotalPrice+installPrice+taxPrice+rollInstallFee;
       orderSummaryStatus.add(overallSubTotal==estimateTotal);
       return orderSummaryStatus.stream().allMatch(value->value==true);

   }

   public boolean calculateProductOrderSummary(){

       float rollInstallFee = 0;
       float subTotalPrice=Utilities.getFloatValueFromString(subtotalPrice);
       float installPrice=Utilities.getFloatValueFromString(installationPrice);
       float taxPrice=Utilities.getFloatValueFromString(salesTaxTotal);
       if(Utilities.elementIsPresent(rollMobileServiceLabel)){
           rollInstallFee=Utilities.getFloatValueFromString(rollMobileServiceFees);
       }
       float estimateTotal=Utilities.getFloatValueFromString(summaryTotalPrice);
       float overallSubTotal=subTotalPrice+installPrice+taxPrice+rollInstallFee;
        return overallSubTotal==estimateTotal;
   }





}
