package com.npg005.user;

public class User {
    private String username;
    private String message;

    public User(String username, String message) {
        this.username = username;
        this.message = message;
        System.out.println("This is a test");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}