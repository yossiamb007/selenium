package com.yossi;

import com.yossi.ui.pageObject.GooglePage;
import org.testng.annotations.Test;

public class TestGooglePage extends TestBase{
    @Test
    public void test1(){
        webAction.getUrl("https://www.google.com");
        GooglePage googlePage = new GooglePage(webAction);
        System.out.println("Title: " + googlePage.getTitle());
        webAction.quitDriver();
    }
}
