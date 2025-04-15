package com.yossi;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Sample Epic")
@Feature("Login Feature")
public class SampleTest {

    @Test(description = "Sample passing test")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Valid Login")
    public void testLoginSuccess() {
        Allure.step("Open login page");
        Allure.step("Enter username and password");
        Allure.step("Click login and verify dashboard");
        Assert.assertTrue(true, "Login should succeed");
    }

    @Test(description = "Sample failing test")
    @Severity(SeverityLevel.NORMAL)
    @Story("Invalid Login")
    public void testLoginFailure() {
        Allure.step("Open login page");
        Allure.step("Enter invalid credentials");
        Allure.step("Click login and expect failure");
        Assert.assertTrue(false, "Login should fail");
    }
}

