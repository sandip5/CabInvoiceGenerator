package com.bridgelabz.utility;

import com.bridgelabz.model.Ride;
import com.bridgelabz.repository.RideRepository;

public class InvoiceService {

    private int userId;

    public Ride[] getListOfRides(int userId) {
        this.userId = userId;
        return RideRepository.usersRides.get(userId);
    }
}
