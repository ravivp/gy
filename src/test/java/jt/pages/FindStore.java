package jt.pages;

import core.utils.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindStore {

    private WebDriver driver;
    public FindStore(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "button[data-qa-id='find-store-button']")
    private WebElement findStoreButton;
    @FindBy(css = "input[data-qa-id='store-finder-pincode']")
    private WebElement searchStoreByCityOrStateOrZip;
    //button[data-qa-id='store-finder-btn']
    //"button.store-search-btn
    @FindBy(css = "img[data-qa-id='store-finder-btn-image']")
    private WebElement store_finder_btn;
    @FindBy(xpath = "(//button[starts-with(@data-qa-id,'select-store-button-')])[1]")
    private WebElement selectStore;

    public void clickOnFindStoreButton(){

        Utilities.clickOnElement(findStoreButton);
    }

    public void searchStoreAndSelectStore(String stateOrCityOrZip){

       Utilities.searchKey(searchStoreByCityOrStateOrZip,stateOrCityOrZip);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Utilities.moveToElementAndClickOn(driver,store_finder_btn);

       Utilities.clickOnElement(selectStore);
    }

    public void selectStoreFromFindStore(){
        Utilities.clickOnElement(selectStore);
    }

}
