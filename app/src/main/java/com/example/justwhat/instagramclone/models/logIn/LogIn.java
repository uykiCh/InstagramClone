package com.example.justwhat.instagramclone.models.logIn;

public class LogIn {

    String email, password;

    public LogIn() {
    }

    public LogIn(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
