Feature: Verify Global footer section
  Background:
    Given I launch the application

    @SanityTest
  Scenario: Verify Footer details
    Given I accept the cookies
    When I wait for "5" seconds
    Then I just valid emil signUp title in footer
    And I verify company name in footer
    And I verify owners name in footer
    And I verify support name in footer
    And I valid Company links in footer section
    And I valid Owners links in footer section
    And I valid Support links in footer section