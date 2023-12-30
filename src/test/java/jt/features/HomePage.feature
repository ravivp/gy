Feature: Verify Home Page Components

  Background:
    Given I launch the application


   @SanityTest
  Scenario: Verify various components on home page
    When I accept the cookies
#    When I am on Home page
   Then I verify Home page title
