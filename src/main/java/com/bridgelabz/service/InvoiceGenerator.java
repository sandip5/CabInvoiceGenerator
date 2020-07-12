package com.bridgelabz.service;

import com.bridgelabz.model.Ride;
import com.bridgelabz.utility.InvoiceSummary;
import com.bridgelabz.utility.RideCategory;

import java.util.Arrays;

public class InvoiceGenerator {

    public double calculateFare(double distance, int time, RideCategory rideCategory) {
        double totalFare = distance * rideCategory.minimumCostPerKM + time * rideCategory.costPerTime;
        return Math.max(totalFare, rideCategory.minimumFare);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare;
        RideCategory rideCategory = InvoiceSummary.rideCategory;
        totalFare = Arrays.stream(rides).mapToDouble(ride -> this.calculateFare(ride.distance, ride.time, rideCategory))
                .sum();
        return new InvoiceSummary(totalFare, rides.length, rideCategory);
    }
}
