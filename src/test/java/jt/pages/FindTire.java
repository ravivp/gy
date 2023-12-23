package jt.pages;

import core.utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindTire {

    private  WebDriver driver;
    WebDriverWait wait;
    public FindTire(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "(//button[@data-qa-id='btn-findtire'])[2]")
    private WebElement findTiresButton;

    @FindBy(css = "input[data-qa-id='tire-finder-vehicle-model-input-year']")
    private WebElement searchVehicleYear;

    // //div[@class='listoption-title ']
    @FindBy(css = "div.listoption-title")
    private WebElement selectAutoSuggestionVehicleDetails;
    @FindBy(css = "input[data-qa-id='tire-finder-vehicle-model-input-make']")
    private WebElement searchVehicleMake;
    @FindBy(css = "input[data-qa-id='tire-finder-vehicle-model-input-model']")
    private WebElement searchVehicleModel;

    //input[data-qa-id='tire-finder-container-input-versionOption']
    @FindBy(css = "input[data-qa-id='tire-finder-vehicle-model-input-versionOption']")
    private WebElement searchVehicleTrim;
    @FindBy(css = "input[data-qa-id='location-input-open']")
    private WebElement enterAddress;
    @FindBy(css ="button[data-qa-id='vehicleTireFinder-overlay-submit-btn']")
    private WebElement vehicleTireFinderSubmitButton;

    //search by tire size
    // css = "button[data-qa-id='tire-finder-btn-tire-size']"

    @FindBy(xpath = "(//button[@data-qa-id='tire-finder-btn-tire-size'])[2]")
    private WebElement tireSizeButton;
    @FindBy(css = "input[data-qa-id='tire-finder-vehicle-model-input-width']")
    private WebElement searchTireWidth;

    @FindBy(css = "input[data-qa-id='tire-finder-vehicle-model-input-aspectRatio']")
    private WebElement searchTireAspectRatio;

    @FindBy(css = "input[data-qa-id='tire-finder-vehicle-model-input-rimDiameter']")
    private WebElement searchTireRimDiameter;

    @FindBy(xpath = "(//button[@data-qa-id='tireSizeTireFinder-overlay-submit-btn'])[2]")
    private WebElement tireSizeTireFinderButton;


    public void tireFinderVehicleInputYear(String searchYearKey){

        Utilities.clickOnElement(searchVehicleYear);
        Utilities.TypeInField(searchVehicleYear,searchYearKey);
        Utilities.clickOnElement(selectAutoSuggestionVehicleDetails);
    }

    public void tireFinderVehicleInputMake(String searchMakeKey){

        Utilities.clickOnElement(searchVehicleMake);
        Utilities.TypeInField(searchVehicleMake,searchMakeKey);
      //  Utilities.searchKey();
        Utilities.clickOnElement(selectAutoSuggestionVehicleDetails);
    }

    public void tireFinderVehicleInputModel(String searchModelKey){

        Utilities.clickOnElement(searchVehicleModel);
        Utilities.TypeInField(searchVehicleModel,searchModelKey);
        Utilities.clickOnElement(selectAutoSuggestionVehicleDetails);
    }
    public void tireFinderVehicleInputTrim(String searchTrimKey){
        Utilities.clickOnElement(searchVehicleTrim);
        Utilities.TypeInField(searchVehicleTrim,searchTrimKey);
        Utilities.clickOnElement(selectAutoSuggestionVehicleDetails);
    }

    public void findTiresButton(){
       Utilities.clickOnElement(findTiresButton);
    }
    public void clickFindTiresSubmitButton(){
        Utilities.clickOnElement(vehicleTireFinderSubmitButton);

    }

    public void enterFullAddressOrZIP(String addressKey){

        Utilities.clickOnElement(enterAddress);
        Utilities.TypeInField(enterAddress,addressKey);


    }

    public void clickOnTireSizeTab(){
        wait= Utilities.explicitlyWait(driver);
        wait.until(ExpectedConditions.visibilityOf(tireSizeButton));
        Utilities.clickOnElement(tireSizeButton);
    }

    public void searchTireByTireSize(String tireWidth,String aspectRatio, String diameter, String zipcode){


        Utilities.clickOnElement(searchTireWidth);
        Utilities.TypeInField(searchTireWidth,tireWidth);
        Utilities.javaScriptExecutor(driver,selectAutoSuggestionVehicleDetails);


        Utilities.clickOnElement(searchTireAspectRatio);
        Utilities.TypeInField(searchTireAspectRatio,aspectRatio);
        Utilities.javaScriptExecutor(driver,selectAutoSuggestionVehicleDetails);

        Utilities.clickOnElement(searchTireRimDiameter);
        Utilities.TypeInField(searchTireRimDiameter,diameter);
        Utilities.javaScriptExecutor(driver,selectAutoSuggestionVehicleDetails);

        enterFullAddressOrZIP(zipcode);
        Utilities.clickOnElement(tireSizeTireFinderButton);


    }

    public void verify_Placeholder_Of_Tire_finder_tire_size_form(){

        //placeholder

    }

    public void tireFinderTireSizeInputWidTh(String tireWidth){
        Utilities.clickOnElement(searchTireWidth);
        Utilities.TypeInField(searchTireWidth,tireWidth);
        Utilities.javaScriptExecutor(driver,selectAutoSuggestionVehicleDetails);
    }

    public void tireFinderTireSizeInputAspectRatio(String aspectRatio){

        Utilities.clickOnElement(searchTireAspectRatio);
        Utilities.TypeInField(searchTireAspectRatio,aspectRatio);
        Utilities.javaScriptExecutor(driver,selectAutoSuggestionVehicleDetails);



    }
    public void tireFinderTireSizeInputDiameter(String diameter){
        Utilities.clickOnElement(searchTireRimDiameter);
        Utilities.TypeInField(searchTireRimDiameter,diameter);
        Utilities.javaScriptExecutor(driver,selectAutoSuggestionVehicleDetails);
    }
    public void clickOnTireSizeButton(){
        Utilities.clickOnElement(tireSizeTireFinderButton);
    }
}

