@Employeedetails
Feature: Employee create,add,delete

Background:
  Given User Launch Browser
  When URL is hit
  And User Enters Username  "Admin" and Password  "admin123"
  And Click on Login button

  @AddEmployee @LoginDataDrivenEmployee
  Scenario Outline: Add New Employee in PIM Page
    When User click on PIM item
    And User click on AddEmployee tab
    Then User fills the details of new Employee from excel with row "<rowIndex>"
    And User clicks on save button
    Then User is added successfully

    Examples:
    | rowIndex |
    |        1 |
    |        2 |
    |        3 |

  @SearchEmp
  Scenario: Search for a given employee
   When User click on PIM item
    And Clicks on Employee List menu item
    When User searches for this employee
    And clicks on Search button
    Then it displays results for employee



  @DeleteEmp
  Scenario: delete employee
    When User click on PIM item
    And Clicks on Employee List menu item
    When User searches for this employee
    And clicks on Search button
    Then it displays results for employee
    When User clicks on select all
    And clicks on delete button
    Then confirmation pop up will appear
    And record will be deleted

