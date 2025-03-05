Feature: User Management

  Scenario: Login to the admin panel
    Given  the user is on the login page
    When  the user enters valid credentials
    And   clicks the login button
    Then  the user should be redirected to the admin page

  Scenario: Add a new user
    Given the user is on the admin page
    When the user navigates to the Add User page
    And enters user details
    And clicks the save button
    Then the new user should be added successfully

  Scenario: Delete the user
    Given the user is on the admin page
    When the user deletes an existing user
    Then the user should be removed successfully
