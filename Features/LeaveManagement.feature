@LeaveDetails
Feature: Apply leave, Check applied leave list


  Background:
    Given User Launch Browser
    When URL is hit
    And User Enters Username  "Admin" and Password  "admin123"
    And Click on Login button

    @ApplyLeave
    Scenario Outline: Apply leave on Leave Page
      When User click on Leave
      And User click on Apply Button
      Then User selects leave type "<LeaveType>" from dropdown
      And User selects from date "<from-date>" from calendar
      And User selects to date "<to-date>" from calendar
      Then User click on apply
      And Leave is applied successfully

      Examples:
      |LeaveType|from-date|to-date|
      | CAN - Personal | 2024-03-06 | 2024-04-06 |


  @CheckLeave
  Scenario Outline: Check leave on LeaveList Page
    When User click on Leave
    And User click on LeaveList Button
    Then User selects leave status "<LeaveStatus>" from dropdown
    And User selects from date "<from-date>" from calendar
    And User selects to date "<to-date>" from calendar
    Then User click on search
    And result is displayed successfully

    Examples:
      |LeaveStatus|from-date|to-date|
      | Rejected | 2024-03-06 | 2024-04-06 |