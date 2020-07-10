package com.bridgelabz.service;

import java.util.Map;

public class RideRepository {

    public static Map<Integer, Ride[]> usersRides;

    public void setUserRides(Map<Integer, Ride[]> usersRides) {
        this.usersRides = usersRides;
    }
}
