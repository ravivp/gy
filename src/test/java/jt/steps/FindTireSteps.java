package jt.steps;

import core.context.Apps;
import core.data.VehicleTestData;
import core.datareader.json;
import core.utils.SearchContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FindTireSteps {

    SearchContext searchContext;
    public FindTireSteps(SearchContext searchContext){

        this.searchContext=searchContext;
    }
    Apps apps=new Apps();
    VehicleTestData vehicleData= json.getVehicleTestData("vehicle");



    @When("I click on global Find Tires")
    public void clickOnFindTires(){


        apps.findTire.findTiresButton();
    }
    @Then("I select option from vehicle year field")
    public void selectVehicleYear(){


//       findTire.tireFinderVehicleInputYear(vehicleTestData.getYear());
        apps.findTire.tireFinderVehicleInputYear(vehicleData.getYear());

    }
    @Then("I select option from vehicle make field")
    public void selectVehicleMake(){

//        findTire.tireFinderVehicleInputMake(vehicleTestData.getMake());
        apps.findTire.tireFinderVehicleInputMake(vehicleData.getMake());

    }
    @Then("I select option from vehicle model field")
    public void selectVehicleModel(){

//        findTire.tireFinderVehicleInputModel(vehicleTestData.getModel());
        apps.findTire.tireFinderVehicleInputModel(vehicleData.getModel());
    }
    @Then("I select option from vehicle trim field")
    public void selectVehicleTrim(){

        apps.findTire.tireFinderVehicleInputTrim(vehicleData.getRim());

    }
    @Then("I enter {string} zipcode")
    public void enterZipcode(String zipcode){

        apps.findTire.enterFullAddressOrZIP(zipcode);
    }
    @Then("I click on find tires submit button")
    public void findTiresSubmitButton(){

        apps.findTire.clickFindTiresSubmitButton();
    }

    @When("I click on Tire Size tab")
    public void tireSizeTab(){

        apps.findTire.clickOnTireSizeTab();
    }

    @When("I search tireWidth {string} aspectRatio {string} rimDiameter {string} and zipcode {string}")
    public void searchTiresWithTireSize(String tireWidth,String aspectRatio, String diameter, String zipcode){

        apps.findTire.searchTireByTireSize(tireWidth, aspectRatio, diameter, zipcode);
    }
    @Then("I verify placeholder of tire search form by tireSize")
    public void verifyPlaceholderOfTireSizeTireFinder(){

    }


    @When("I select {string} option from tire size width field")
    public void selectTireWidth(String tireWidth){

        apps.findTire.tireFinderTireSizeInputWidTh(tireWidth);
    }
    @When("I select {string} option from tire aspectRatio field")
    public void selectTireAspectRatio(String aspectRatio){

        apps.findTire.tireFinderTireSizeInputAspectRatio(aspectRatio);
    }

    @When("I select {string} option from tire rim field")
    public void selectTireDiameter(String diameter){

        apps.findTire.tireFinderTireSizeInputDiameter(diameter);
    }

    @When("I enter {string} in Enter Vehicle Year text box and select Combobox")
    public void selectYear(String year){


        apps.findTire.tireFinderVehicleInputYear((String) json.getValue(year));
    }
    @When("I enter {string} in Enter Vehicle Make text box and select Combobox")
    public void selectMake(String make){
        apps.findTire.tireFinderVehicleInputMake((String) json.getValue(make));

    }
    @When("I provided data {string} Enter vehicle Trim test box and select Combobox")
    public void selectModel(String model){
        apps.findTire.tireFinderVehicleInputModel((String) json.getValue(model));

    }
    @When("I provided data {string} in vehicle Model Rim tablet")
    public void selectRim(String rim){
        apps.findTire.tireFinderVehicleInputTrim((String) json.getValue(rim));
    }
    @When("I just click on tire size search button")
    public void clickOnTireSearchButton(){
        apps.findTire.clickOnTireSizeButton();
    }
}
