Feature: Google search

  Scenario: Search value on Google
    Given I launch chrome browser
    When I open google page
    Then I set value in search
    Then I verify that the amount result is not zero
    And Close browser