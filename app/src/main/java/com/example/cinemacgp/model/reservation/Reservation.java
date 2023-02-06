package com.example.cinemacgp.model.reservation;

import com.example.cinemacgp.model.user.User;

import java.util.Date;

public class Reservation {
    private User user;
    private Integer number;
    private String movieName;
    private int status;
    private String createdAt;

    public Reservation(User user, Integer number, String movieName, int status) {
        this.user = user;
        this.number = number;
        this.movieName = movieName;
        this.status = status;
        this.createdAt = new Date().toString();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return createdAt;
    }

    public void setDate(String date) {
        this.createdAt = date;
    }
}
