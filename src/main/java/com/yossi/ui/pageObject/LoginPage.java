package com.yossi.ui.pageObject;

public class LoginPage {

    public boolean isLoginButtonVisible() {
        return true; // Simulating UI element visibility
    }

    public String login(String username, String password) {
        if ("admin".equals(username) && "password123".equals(password)) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }

    public String getTitle() {
        return "Welcome to the Dashboard";
    }
}

