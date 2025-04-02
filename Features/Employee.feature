@Employeedetails
Feature: Employee create,add,delete

Background:
  Given User Launch Edge Browser
  When User open URL
  And User Enters Username as "Admin" and Password as "admin123"
  And Click on Login

  @AddEmployee
  Scenario Outline: Add New Employee in PIM Page
    When User click on PIM item
    And User click on AddEmployee tab
    Then User fills the details of new Employee <firstname> and <midname> and <lastname>
    And User clicks on save button
    Then User is added successfully

    Examples:
    |firstname         | midname        |lastname         |
    |   UserTest1      |  UserTest2     |  UserTest3      |


  @SearchEmp
  Scenario Outline: Search for a given employee
   When User click on PIM item
    And Clicks on Employee List menu item
    When User searchs for this employee <Employee name>
    And clicks on Search button
    Then it displays results for employee <Employee name>

   Examples:
     | Employee name |
      | UserTest1  |
#
#  @DeleteEmp
#  Scenario Outline: Search for a given employee
#    When User hover over PIM menu
#    And Clicks on Employee List menu item
#    When User searchs for this employee <Employee name>
#    And clicks on Search button
#    Then it displays results
#    When User clicks on select all
#    And clicks on delete button
#    Then confirmation pop up will appear
#    And record will be deleted
#
#
#    Examples:
#      | Employee name |
#      | "UserTest1" |
#
