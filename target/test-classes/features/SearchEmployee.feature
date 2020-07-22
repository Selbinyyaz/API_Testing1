@searchEmployee @sprint13
Feature: Employee Search

  Background: 
    Given user is logged with valid admin credentials
    And user navigate to employee list page


  Scenario: Search employee by id
    When user enters valid employee id "14099"
    And click on search button
    Then user see employee information is displayed

  @searchbyname
  Scenario: Search employee by name
    When user enters valid employee "John" and "Smith"
    And click on search button
    Then user see employee information is displayed
