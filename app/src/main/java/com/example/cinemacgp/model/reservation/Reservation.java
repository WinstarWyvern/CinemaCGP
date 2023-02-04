package com.example.cinemacgp.model.reservation;

public class Reservation {
    private String personName;
    private Integer number;
    private String movieName;

    public Reservation(String personName, Integer number, String movieName) {
        this.personName = personName;
        this.number = number;
        this.movieName = movieName;
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
}
