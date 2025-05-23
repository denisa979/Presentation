package com.project.step_definitions;

import com.project.pages.CareersPage;
import com.project.pages.CompanyPage;
import com.project.utilities.BrowserUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class CompanyPageStepDefinition {

    private CompanyPage companyPage = new CompanyPage();
    private CareersPage careersPage;

    @When("User is on the company page")
    public void user_is_on_the_company_page() {
        Assert.assertTrue("Company logo is not displayed", companyPage.isLogoDisplayed());

    }

   @Then("User should be able to see company\"An agency fueled by purpose, with impact you can certify\"")
public void user_should_be_able_to_see_company_an_agency_fueled_by_purpose_with_impact_you_can_certify() {
       BrowserUtils.waitFor(3);
    String expected = "An agency fueled by purpose, with impact you can certify";
String actual = companyPage.getWelcomeMessageText();

// Normalize whitespace and line breaks
String normalizedExpected = expected.replaceAll("\\s+", " ").trim();
String normalizedActual = actual.replaceAll("\\s+", " ").trim();

Assert.assertEquals("Company message mismatch", normalizedExpected, normalizedActual);

}

    @And("User should see {int} options on the manu bar:")
    public void userShouldSeeOptionsOnTheManuBar(int expectedCount, DataTable dataTable) {
        List<String> expectedOptions = dataTable.asList();
        List<WebElement> menuOptions = companyPage.getMenuOptions();

        // Fix: Correct parameter order (message, expected, actual)
        assertEquals("Menu option count mismatch",
                expectedCount,
                menuOptions.size() // Actual count from the page
        );

        // Optional: Verify text of each menu option
        List<String> actualOptions = menuOptions.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertEquals("Menu options text mismatch",
                expectedOptions,
                actualOptions
        );

   }

    @Then("User should be able to click on {string}")
    public void click_button(String buttonText) {
        if ("Careers".equalsIgnoreCase(buttonText)) {
            companyPage.clickCareersButton();
        } else {
            throw new IllegalArgumentException("Unsupported button: " + buttonText);
        }
    }

   @Then("User should land on careers page")
public void verify_careers_page() {
       careersPage = new CareersPage(); // Initialize after navigation
       Assert.assertTrue("Careers page intro not displayed", careersPage.isCareersIntroDisplayed());
   }

    @Then("User click {string}")
    public void user_click(String buttonText) {
        if ("View Openings".equalsIgnoreCase(buttonText)) {
            careersPage.clickOpeningsButton(); // Corrected: Use careersPage
        } else {
            throw new IllegalArgumentException("Unsupported button: " + buttonText);
        }
    }

  @And("User should see all  open positions")
    public void userShouldSeeAllOpenPositions() {
       List<String> positions = careersPage.getOpenPositionsText();
       List<String> numbers = careersPage.getOpenPositionNumbers();

       Assert.assertFalse("No open positions found", positions.isEmpty());
       assertEquals("Position count and numbering mismatch", positions.size(), numbers.size());
   }
}
