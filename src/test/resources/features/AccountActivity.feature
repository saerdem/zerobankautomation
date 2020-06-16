@accountActivity
Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given the user is logged in

  Scenario Outline: <accountType> account redirect
    When the user clicks on "<accountType>" link on the Account Summary page
    Then the "<pageTitle>" page should be displayed
    And Account drop down should have "<accountType>" selected

    Examples:
      | accountType | pageTitle        |
      | Savings     | Account Activity |
      | Checking    | Account Activity |
      | Loan        | Account Activity |
      | Credit Card | Account Activity |
      | Brokerage   | Account Activity |