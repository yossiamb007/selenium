package com.yossi.ui.pageObject;

import com.yossi.ui.common.WebAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SwagLoginPage extends BasePageFactory{

    @FindBy(id = "user-name")
    private WebElement userNameElement;
    @FindBy(id = "password")
    private WebElement passwordElement;
    @FindBy(id = "login-button")
    private WebElement loginBtnElement;//"//*[contains(@class, 'my-class')]
    @FindBy(xpath = "//select[contains(@data-test, 'product-sort-container')]")
    private WebElement filterElement;
    @FindBy(xpath = "//div[contains(@data-test, 'inventory-item-description')]")
    private List<WebElement> itemElements;

    public SwagLoginPage(WebAction webAction) {
        super(webAction);
    }

    public boolean isLoginButtonVisible() {
        return true; // Simulating UI element visibility
    }

    public String login(String username, String password) {
        webAction.sendKeys(userNameElement,username);
        webAction.sendKeys(passwordElement, password);
        webAction.click(loginBtnElement);
        return webAction.getTitle();
    }

    public void filter(String filterByText) {
       webAction.selectFromDropDown(filterElement, filterByText);
    }
    public boolean validFiltered() {
        char firstCharOfFirstItem = itemElements.get(0).getText().trim().charAt(0);
        char firstCharOfLastItem = itemElements.get(itemElements.size() -1).getText().trim().charAt(0);
        return (firstCharOfFirstItem > firstCharOfLastItem);
    }
}

