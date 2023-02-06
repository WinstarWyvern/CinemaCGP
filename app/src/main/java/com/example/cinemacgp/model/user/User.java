package com.example.cinemacgp.model.user;

import java.util.Date;

public class User {
    private String name;
    private String createdAt;

    public User(String name) {
        this.name = name;
        this.createdAt = new Date().toString();
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
}
