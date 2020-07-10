package com.bridgelabz.service;

public class InvoiceSummary {
    private final double totalFare;
    private final int numberOfRides;
    private final double averageFare;
    public static String rideCategory;

    public InvoiceSummary(double totalFare, int numberOfRides, String rideCategory) {
        this.rideCategory = rideCategory;
        this.totalFare = totalFare;
        this.numberOfRides = numberOfRides;
        this.averageFare = this.totalFare / this.numberOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return Double.compare(that.totalFare, totalFare) == 0 &&
                numberOfRides == that.numberOfRides &&
                Double.compare(that.averageFare, averageFare) == 0;
    }
}
