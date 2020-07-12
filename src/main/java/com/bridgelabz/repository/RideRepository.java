package com.bridgelabz.repository;

import com.bridgelabz.model.Ride;

import java.util.Map;

public class RideRepository {

    public static Map<Integer, Ride[]> usersRides;

    public void setUserRides(Map<Integer, Ride[]> usersRides) {
        this.usersRides = usersRides;
    }
}
