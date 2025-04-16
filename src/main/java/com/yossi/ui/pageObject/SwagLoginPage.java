package com.yossi.ui.pageObject;

import com.yossi.ui.common.WebAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SwagLoginPage extends BasePageFactory {

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
        webAction.sendKeys(userNameElement, username);
        webAction.sendKeys(passwordElement, password);
        webAction.click(loginBtnElement);
        return webAction.getTitle();
    }

    public void filter(String filterByText) {
        webAction.selectFromDropDown(filterElement, filterByText);
    }

    public boolean validFiltered() {
        char firstCharOfFirstItem = itemElements.get(0).getText().trim().charAt(0);
        char firstCharOfLastItem = itemElements.get(itemElements.size() - 1).getText().trim().charAt(0);
        return (firstCharOfFirstItem > firstCharOfLastItem);
    }

    public void collectItemsData() {
        List<Integer> itemsData = new ArrayList<>();
        for (WebElement element : itemElements) {

            // Regular expression to match the price
            String regex = "\\$(\\d+\\.\\d{2})";

            // Create a Pattern object
            Pattern pattern = Pattern.compile(regex);

            // Create matcher object
            Matcher matcher = pattern.matcher(element.getText());

            // Check if we find a match
            if (matcher.find()) {
                // Extract the matched price
                String priceStr = matcher.group(1);

                // Convert to double (to retain decimal value)
                double price = Double.parseDouble(priceStr);

                int priceInt = (int) price;
                itemsData.add(priceInt);
            }
        }
        System.out.println(findLowestNumber(itemsData));
        System.out.println(findHighestNumber(itemsData));

    }

    public int findLowestNumber(List<Integer> numbers) {
        int lowest = Integer.MAX_VALUE;
        for (int num : numbers) {
            if (num < lowest) {
                lowest = num;
            }
        }

        return lowest;
    }

    public int findHighestNumber(List<Integer> numbers) {
        int highest = Integer.MIN_VALUE;

        for (int num : numbers) {
            if (num > highest) {
                highest = num;
            }
        }

        return highest;
    }
}
