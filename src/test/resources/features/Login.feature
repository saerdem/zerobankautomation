@login
Feature: Only Authorized users should be login

  Background:
    Given the user is in the login page

  Scenario: login with authorized credentials
    When the user enter valid credentials "username" "password"
    Then Account summary page should be displayed

  Scenario: login with wrong/blank username
    When the user enter valid credentials "" "password"
    Then Error message "Login and/or password are wrong" should be displayed.

  Scenario: login with wrong/blank password
    When the user enter valid credentials "username" ""
    Then Error message "Login and/or password are wrong" should be displayed.

  Scenario: login with blank username/password
    When the user enter valid credentials "" ""
    Then Error message "Login and/or password are wrong" should be displayed.