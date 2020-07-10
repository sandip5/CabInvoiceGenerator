package com.bridgelabz.service;

public class InvoiceGenerator {

    private int COST_PER_TIME;
    private double MINIMUM_COST_PER_KM;
    private double MINIMUM_FARE;

    public double calculateFare(double distance, int time, int COST_PER_TIME,
                                double MINIMUM_COST_PER_KM, double MINIMUM_FARE) {
        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        if (totalFare < MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalFare;
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        String rideCategory = InvoiceSummary.rideCategory;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time, rideCategory);
        }
        return new InvoiceSummary(totalFare, rides.length, rideCategory);
    }

    public double calculateFare(double distance, int time, String rideCategory) {
        switch (rideCategory) {
            case "PREMIUM_RIDES":
                COST_PER_TIME = 2;
                MINIMUM_COST_PER_KM = 15.0;
                MINIMUM_FARE = 20.0;
                return calculateFare(distance, time, COST_PER_TIME, MINIMUM_COST_PER_KM, MINIMUM_FARE);
            case "NORMAL_RIDES":
                COST_PER_TIME = 1;
                MINIMUM_COST_PER_KM = 10.0;
                MINIMUM_FARE = 5.0;
                return calculateFare(distance, time, COST_PER_TIME, MINIMUM_COST_PER_KM, MINIMUM_FARE);
            default:
                throw new IllegalStateException("Unexpected value: " + rideCategory);
        }
    }
}
