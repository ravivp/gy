Feature: Verify various components on cart page

  Background:
    Given I launch the application

  #@SanityTest
  Scenario: Verify components on cart page
    Given I accept the cookies
    When I click on global Find Tires
#     When I just on click on vehicle tap
    When I wait for "5" seconds
    When I enter "Vehicle.Year" in Enter Vehicle Year text box and select Combobox
    And I enter "Vehicle.Make" in Enter Vehicle Make text box and select Combobox
    And I provided data "vehicle.Model" Enter vehicle Trim test box and select Combobox
    And I provided data "vehicle.Rim" in vehicle Model Rim tablet
    And I enter "44333" zipcode
    And I click on find tires submit button
    Then I wait for "5" seconds
    Then I click on add to cart on PLP page
    Then I select inStore on Mini Cart
    Then I click on add to cart on Mini Cart
    When I click on Select Store from find store
    Then I verify cart header on cart page
    Then I verify selected tire on cart page
    And I verify product details in cart page
    And I just verify total price of tire In cart page
    And I verify "services.alignment" add on service in cart
    And I verify "services.RH" add on service in cart
    And I add "services.alignment" service in cart
    And I add "services.RH" service in cart