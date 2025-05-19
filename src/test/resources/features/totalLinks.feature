Feature: Total links on the company page. 

  Scenario:User prints out total links on the company page.
    
    Given User is on the company page
    When User send request to count total links on the company home page
    Then User get number of links together with the links names
