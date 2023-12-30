Feature: Verify all components in Mini Cart

  Background:
    Given I launch the application

  Scenario: Verify various components in mini cart by passing vehicle details
    Given I accept the cookies
    When I click on global Find Tires
    When I wait for "5" seconds
    When I enter "Vehicle.Year" in Enter Vehicle Year text box and select Combobox
    And I enter "Vehicle.Make" in Enter Vehicle Make text box and select Combobox
    And I provided data "vehicle.Model" Enter vehicle Trim test box and select Combobox
    And I provided data "vehicle.Rim" in vehicle Model Rim tablet
    And I enter "44333" zipcode
    And I click on find tires submit button
    Then I wait for "5" seconds
    Then I click on add to cart on PLP page
