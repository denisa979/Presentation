package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CompanyPage extends BasePage{

   private By logo = By.xpath("//a[@class='nav__brand']");
    private By welcomeMessage = By.xpath("//div//h1");
    private By primaryMenu = By.xpath("//ul[@id='menu-primary-menu']/li");
    private By careersBtn = By.xpath("//span[@data-text='Careers']");

    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

    public String getWelcomeMessageText() {
        return driver.findElement(welcomeMessage).getText();
    }

    public List<WebElement> getMenuOptions() {
        return driver.findElements(primaryMenu);
    }

    public void clickCareersButton() {
        driver.findElement(careersBtn).click();
    }
}
