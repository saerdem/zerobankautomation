@accountSummary
Feature: Account Summary page

  Background:
    Given the user is in the login page
    And the user enter valid credentials "username" "password"
    When the user navigates to "Account Summary"


  Scenario: Page Title
    Then page should have the title "Zero – Account Summary"


  Scenario: Account Types
    Then page should have to following account types:
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |


  Scenario: Credit Accounts
    Then Credit Accounts table must have the following columns
      | Account     |
      | Credit Card |
      | Balance     |
