package com.bridgelabz.service;

public class InvoiceService {

    private int userId;

    public Ride[] getListOfRides(int userId) {
        this.userId = userId;
        return RideRepository.usersRides.get(userId);
    }
}
