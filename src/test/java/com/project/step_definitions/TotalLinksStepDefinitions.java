package com.project.step_definitions;

import com.project.pages.CompanyPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.List;


public class TotalLinksStepDefinitions {
    CompanyPage companyPage = new CompanyPage();
   
    @When("User send request to count total links on the company home page")
public void user_send_request_to_count_total_links_on_the_company_home_page() {

        List<String> allLinks = companyPage.getLinks();
        System.out.println("allLinks = " + allLinks);
    }
@Then("User get number of links together with the links names")
public void user_get_number_of_links_together_with_the_links_names() {
      List<String>numberOfLinks = companyPage.getLinks();
    System.out.println("numberOfLinks.size() = " + numberOfLinks.size());
    
}

}
