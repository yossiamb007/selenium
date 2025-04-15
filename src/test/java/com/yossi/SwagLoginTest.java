package com.yossi;

import com.yossi.ui.pageObject.SwagLoginPage;
import com.yossi.ui.pageObject.WikipediaPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwagLoginTest extends TestBase{
    private final String wikiUITestAutoUrl = "https://www.saucedemo.com/";
//    @Test
//    public void testLoginSuccess(){
//        webAction.getUrl(wikiUITestAutoUrl);
//        SwagLoginPage loginPage = new SwagLoginPage(webAction);
//
//        String result = loginPage.login("standard_user", "secret_sauce");
//        Assert.assertEquals(result, "Swag Labs", "Expected successful login");
//    }
    @Test
    public void testFilter(){
        webAction.getUrl(wikiUITestAutoUrl);
        SwagLoginPage loginPage = new SwagLoginPage(webAction);

        String result = loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(result, "Swag Labs", "Expected successful login");
        loginPage.filter("Name (Z to A)");
        boolean isFiltered = loginPage.validFiltered();
        Assert.assertTrue(isFiltered, "Expected successful filtered");
    }
}

