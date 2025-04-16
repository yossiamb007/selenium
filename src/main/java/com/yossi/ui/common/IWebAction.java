package com.yossi.ui.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface IWebAction {
    void click(WebElement element);
    void click(WebElement element, String elementName);
    void click(WebElement element, String elementName, int toDisappearTimeOut);
    void getUrl(String url);
    WebElement findElement(By by);
    List<WebElement> findElements(By by);
    void sendKeys(WebElement element, String value);
    void sendKeys(WebElement element, String value, boolean shouldClearTextBox);
    void isElementExist(WebElement element);
    boolean isElementDisplayed(By locator, int timeoutInSeconds);
    void quitDriver();
    String getTitle();
    String getText(WebElement element);
    void selectFromDropDown(WebElement element, String optionText);
}
