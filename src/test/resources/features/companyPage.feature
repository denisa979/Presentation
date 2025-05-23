
Feature: Company page

      Scenario: Verify user can have access to open positions

        When User is on the company page
        Then User should be able to see company"An agency fueled by purpose, with impact you can certify"
        And User should see 6 options on the manu bar:
        |What we do            |
        |Who we are            |
        |Healthcare              |
        |Company we keep|
        |Careers                    |
        |Work with us         |

        Then User should be able to click on "Careers"
        And User should land on careers page
        Then User click "View Openings"
        And User should see all  open positions
