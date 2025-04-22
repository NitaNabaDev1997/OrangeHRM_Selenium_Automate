Feature: Login in OrangeHRM Application

@LoginEmployee @SearchEmp
  Scenario: Testing login functionality using valid Credential
    Given User Launch Edge Browser
    When User open URL
    And User Enters Username as "Admin" and Password as "admin123"
    And Click on Login
    Then Page title should be "OrangeHRM"
    When User click on profile link
    And click on Logout link
    Then close the browser
