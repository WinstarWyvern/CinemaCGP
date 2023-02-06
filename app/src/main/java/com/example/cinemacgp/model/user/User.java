package com.example.cinemacgp.model.user;

import java.util.Date;

public class User {
    private String name;
    private String createdAt;
    private int isAdmin;

    public User(String name, int isAdmin) {
        this.name = name;
        this.createdAt = new Date().toString();
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
}
