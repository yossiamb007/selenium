package com.yossi.ui.pageObject;

import com.yossi.ui.common.WebAction;

public class GooglePage extends BasePageFactory{
    public GooglePage(WebAction webAction) {
        super(webAction);
    }
    public String getTitle(){
        return webAction.getTitle();
    }
}
