Feature: As a user of DNV
  I want to sign in to Veracity and add Rules and Standards Explorer service into my services
  I want to sign in to Veracity and check out if Rules and Standards Explorer service was included into my services

  Scenario: Successful user login in Veracity and successful service added
    Given user in the Signin Veracity home page
    When user type username and password and log in
    And user accepts all cookies
    And user clicks on My Services
    And user clicks on Add service
    And user types "Rules and Standards Explorer" on search bar
    And user clicks on Rules and Standars Explorer service
    And user clicks on Free access button
    And user accepts terms and conditions
    Then user can read "Thanks for your interest in Rules and Standards Explorer"

  Scenario: Successful user login in Veracity and successful service checked
    Given user in the Signin Veracity home page
    When user type username and password and log in
    And user accepts all cookies
    And user clicks on My Services
    Then user can see added service called "Rules and Standards Explorer"

