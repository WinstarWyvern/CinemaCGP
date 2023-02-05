package com.example.cinemacgp.model.reservation;

import java.util.Date;

public class Reservation {
    private String personName;
    private Integer number;
    private String movieName;
    private int status;
    private String date;

    public Reservation(String personName, Integer number, String movieName) {
        this.personName = personName;
        this.number = number;
        this.movieName = movieName;
        this.status = 1;
        this.date = new Date().toString();
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
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
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
