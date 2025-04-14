package com.yossi;

import com.yossi.ui.pageObject.WikipediaPage;
import org.testng.annotations.Test;

public class WikiTest extends TestBase{
    private final String wikiUITestAutoUrl = "https://en.wikipedia.org/wiki/Test_automation";
    @Test
    public void testWiki(){
        webAction.getUrl(wikiUITestAutoUrl);
        WikipediaPage wikipediaPage = new WikipediaPage(webAction);
        System.out.println("Title: " + wikipediaPage.getTestDrivenDevText());
        webAction.quitDriver();
    }
}

