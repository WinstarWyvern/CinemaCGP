package com.example.cinemacgp.model.reservation;

public class Reservation {
    private String personName;
    private int number;
    private String movieName;
    private String date;

    public Reservation(String personName, int number, String movieName, String date) {
        this.personName = personName;
        this.number = number;
        this.movieName = movieName;
        this.date = date;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
