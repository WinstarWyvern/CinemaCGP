package com.example.cinemacgp.database;

import com.example.cinemacgp.model.user.User;

import java.util.ArrayList;

public class UserDatabase {
    private static UserDatabase userDb = null;

    private UserDatabase() {
    }

    public static UserDatabase getInstance() {
        if (userDb == null) {
            userDb = new UserDatabase();
            generateDummyUser();
        }
        return userDb;
    }

    private static ArrayList<User> users = new ArrayList<>();

    private static void generateDummyUser() {
        users.add(new User("Andi",0));
        users.add(new User("Tono",1));
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
