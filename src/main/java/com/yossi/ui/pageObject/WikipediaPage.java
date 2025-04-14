package com.yossi.ui.pageObject;

import com.yossi.ui.common.WebAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikipediaPage extends BasePageFactory{

    @FindBy(id = "Test-driven_development")
    private WebElement testDrivenDevTitleElmLocator;
    @FindBy(css = "h3:has(#Test-driven_development)+p")
    private WebElement testDrivenDevElmLocator;
    public WikipediaPage(WebAction webAction) {
        super(webAction);
    }
    public String getTestDrivenDevText()
    {
        String res = null;
        if (webAction.isElementDisplayed(By.cssSelector("Test-driven_development"), 10))
        {
            res = webAction.getText(testDrivenDevTitleElmLocator) + " " + webAction.getText(testDrivenDevElmLocator);
        }
        else
        {
            //Log it to test reporter
        }
        return res;
    }
}
