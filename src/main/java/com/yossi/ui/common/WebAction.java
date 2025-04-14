package com.yossi.ui.common;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebAction implements IWebAction {
    private WebDriver driver;

    public WebAction(WebDriver driver){
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return driver;
    }
    @Override
    public void click(WebElement element) {

    }

    @Override
    public void click(WebElement element, String elementName) {

    }


    @Step("Going to click on button: {elementName}")
    @Override
    public void click(WebElement element, String elementName, int toDisappearTimeOut) {

    }

    @Step("Going to get url: {url}")
    @Override
    public void getUrl(String url) {
        driver.get(url);
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public void sendKeys(WebElement element, String value) {

    }

    @Override
    public void sendKeys(WebElement element, String value, boolean shouldClearTextBox) {

    }

    @Override
    public void isElementExist(WebElement element) {

    }

    /**
     * Checks if an element exists and is displayed within the given timeout.
     *
     * @param locator The By locator for the element.
     * @param timeoutInSeconds Timeout in seconds.
     * @return true if the element is found and displayed, false otherwise.
     */
    @Step("Going to check if element exist: {locator}")
    @Override
    public boolean isElementDisplayed(By locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return element.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
    @Override
    public void quitDriver() {
        driver.quit();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public String getText(WebElement element) {
        return element.getText();
    }
}
