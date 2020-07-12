package com.bridgelabz.utility;

public enum RideCategory {
    PREMIUM(2, 15.0, 20.0), BASIC(1, 10.0, 5.0);

    public int costPerTime;
    public double minimumCostPerKM;
    public double minimumFare;

    RideCategory(int costPerTime, double minimumCostPerKM, double minimumFare) {
        this.costPerTime = costPerTime;
        this.minimumCostPerKM = minimumCostPerKM;
        this.minimumFare = minimumFare;
    }
}
