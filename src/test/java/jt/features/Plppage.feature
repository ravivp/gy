Feature: Verify various components on PLP page
   Background:
     Given I launch the application

   Scenario: Verify various components on PLP
     When I accept the cookies
#     When I click on find store link on Global header
#     When I search store by "44333" zipcode
     When I click on global Find Tires
     Then I select option from vehicle year field
     Then I select option from vehicle make field
     Then I select option from vehicle model field
     Then I select option from vehicle trim field
     Then I enter "44333" zipcode
     Then I click on find tires submit button
#     Then I verify search vehicle on PLP page
     Then I wait for "5" seconds
     Then I click on add to cart on PLP page
     Then I select inStore on Mini Cart
     Then I click on add to cart on Mini Cart
     When I click on Select Store from find store
     Then I verify cart header on cart page
     Then I verify selected tire on cart page
     And I verify product details in cart page
     And I just verify total price of tire In cart page

   Scenario: Verify various components on PLP page by tire size
     When I accept the cookies
     When I click on global Find Tires
     When I wait for "5" seconds
     When I click on Tire Size tab
     When I search tireWidth "215" aspectRatio "45" rimDiameter "17" and zipcode "44333"

   Scenario: Verify tire search with vehicle details from test data file
     When I accept the cookies
     When I click on global Find Tires
#     When I just on click on vehicle tap
     When I enter "Vehicle.Year" in Enter Vehicle Year text box and select Combobox
     And I enter "Vehicle.Make" in Enter Vehicle Make text box and select Combobox
     And I provided data "vehicle.Model" Enter vehicle Trim test box and select Combobox
     And I provided data "vehicle.Rim" in vehicle Model Rim tablet
     And I enter "44333" zipcode
     And I click on find tires submit button

  Scenario: Verify tire finder module with tire size
    When I accept the cookies
    When I click on global Find Tires
    And I wait for "5" seconds
    And I click on Tire Size tab
    When I select "225" option from tire size width field
    And I select "45" option from tire aspectRatio field
    And I select "17" option from tire rim field
    And I just click on tire size search button

