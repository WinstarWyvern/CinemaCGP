package com.example.cinemacgp.database;

import com.example.cinemacgp.model.reservation.Reservation;

import java.util.ArrayList;

public class ReservationDatabase {
    private static ReservationDatabase reservationDb = null;

    private ReservationDatabase() {
    }

    public static ReservationDatabase getInstance() {
        if (reservationDb == null) {
            reservationDb = new ReservationDatabase();
        }
        return reservationDb;
    }

    private static ArrayList<Reservation> reservations = new ArrayList<>();

    public void addReservation(Reservation r) {
        reservations.add(r);
    }

    public ArrayList<Reservation> getAllReservation() {
        return reservations;
    }
}
