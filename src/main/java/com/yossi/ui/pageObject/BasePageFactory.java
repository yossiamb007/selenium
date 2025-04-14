package com.yossi.ui.pageObject;

import com.yossi.ui.common.WebAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageFactory {
    protected WebAction webAction;
    protected BasePageFactory(WebAction webAction){
        this.webAction = webAction;
        PageFactory.initElements(this.webAction.getDriver(), this);
    }
}
