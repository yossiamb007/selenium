package com.yossi;

import com.yossi.ui.pageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage();
    }

    @Test
    public void testLoginSuccess() {
        String result = loginPage.login("admin", "password123");
        Assert.assertEquals(result, "Login successful", "Expected successful login");
    }

    @Test
    public void testLoginFailure() {
        String result = loginPage.login("admin", "wrongpassword");
        Assert.assertEquals(result, "Invalid credentials", "Expected login to fail with invalid password");
    }

    @Test
    public void testLoginButtonVisibility() {
        Assert.assertTrue(loginPage.isLoginButtonVisible(), "Login button should be visible");
    }

    @Test
    public void testTitle() {
        Assert.assertTrue(loginPage.getTitle().contains("Dashboard"), "Page title should contain 'Dashboard'");
    }
}

