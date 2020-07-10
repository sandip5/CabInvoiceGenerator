package com.bridgelabz.test;

import com.bridgelabz.service.Ride;

import static com.bridgelabz.test.RideRepository.usersRides;

public class InvoiceService {

    private int userId;

    public Ride[] getListOfRides(int userId) {
        this.userId = userId;
        return usersRides.get(userId);
    }
}
