package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CareersPage extends BasePage {

    private By careersIntro = By.xpath("//div[@class='l__cnt-wrapper' and contains(., 'Women-owned/led')]");
    private By positionTitles = By.xpath("//span[@class='accordion-title']");
    private By numberingElements = By.cssSelector("span.l__count");
    private By viewOpeningsBtn = By.xpath("//div[@class='magnetic']");
    private By applyTodayBtn = By.linkText("Apply Today");

    public CareersPage() {
        super();
    }

    public boolean isCareersIntroDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement introElement = wait.until(ExpectedConditions.visibilityOfElementLocated(careersIntro));
            return introElement.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getCareersIntroText() {
        return driver.findElement(careersIntro).getText().trim();
    }

    public List<String> getOpenPositionsText() {
        return getElementsText(positionTitles);
    }

    public List<String> getOpenPositionNumbers() {
        return getElementsText(numberingElements);
    }

    public int getOpenPositionsCount() {
        return driver.findElements(positionTitles).size();
    }

    public void clickOpeningsButton() {
        driver.findElement(viewOpeningsBtn).click();
    }

    public void clickApplyTodayBtn(){
        driver.findElement(applyTodayBtn).click();
    }
}
