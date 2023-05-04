# Created by malfi at 04/05/2023
Feature: Login to Guru 99 Bank App

  Scenario Outline: Sign in existing user (manager)
    Given The existing user is on the login page
    When Types "<login>"
    And password "<password>"
    And clicks login
    Then is signed in succesfully

    Examples:
      | login      | password |
      | mngr495031 | UzEbyvE  |
