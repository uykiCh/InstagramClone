package com.example.justwhat.instagramclone.Activities.MVPActivitySignUp;

public class ModelActivitySignUp {

    String email, password, fullName, username;

    public ModelActivitySignUp(String email, String password, String fullName, String username) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.username = username;
    }

    public ModelActivitySignUp(){

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
