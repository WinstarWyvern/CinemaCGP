package com.example.cinemacgp.database;

import com.example.cinemacgp.model.reservation.Reservation;
import com.example.cinemacgp.model.user.User;

import java.util.ArrayList;

public class ReservationDatabase {
    private static ReservationDatabase reservationDb = null;

    private ReservationDatabase() {
    }

    public static ReservationDatabase getInstance() {
        if (reservationDb == null) {
            reservationDb = new ReservationDatabase();
            generateDummyReservations();
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

    public ArrayList<Reservation> getReservationsByNameOnGoing(String name) {
        ArrayList<Reservation> filtered = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getUser().getName().equals(name) && r.getStatus() == 1) {
                filtered.add(r);
            }
        }
        return filtered;
    }

    public ArrayList<Reservation> getReservationsByNameCompleted(String name) {
        ArrayList<Reservation> filtered = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getUser().getName().equals(name) && r.getStatus() == 0) {
                filtered.add(r);
            }
        }
        return filtered;
    }

    private static void generateDummyReservations() {
        reservations.add(new Reservation(new User("Andi",0),1, "Black Panther", 0));
        reservations.add(new Reservation(new User("Andi",0),2, "Spiderman", 0));
        reservations.add(new Reservation(new User("Andi",0),3, "Superman", 0));
        reservations.add(new Reservation(new User("Andi",0),4, "Batman", 0));

        reservations.add(new Reservation(new User("Andi",0),1, "Jackie Chan", 1));
        reservations.add(new Reservation(new User("Andi",0),2, "Thor", 1));
        reservations.add(new Reservation(new User("Andi",0),3, "Naruto", 1));
        reservations.add(new Reservation(new User("Andi",0),2, "Tom & Jerry", 1));
    }
}
