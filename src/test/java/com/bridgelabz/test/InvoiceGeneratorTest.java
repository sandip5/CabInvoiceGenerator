package com.bridgelabz.test;

import com.bridgelabz.service.InvoiceGenerator;
import com.bridgelabz.service.InvoiceSummary;
import com.bridgelabz.service.Ride;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class InvoiceGeneratorTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTheTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        String rideCategory = "NORMAL_RIDES";
        double fare = invoiceGenerator.calculateFare(distance, time, rideCategory);
        Assert.assertEquals(25, fare,0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        String rideCategory = "NORMAL_RIDES";
        double fare = invoiceGenerator.calculateFare(distance, time, rideCategory);
        Assert.assertEquals(5, fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = { new Ride(2.0, 5),
                         new Ride(0.1, 1)
                        };

        String rideCategory = "NORMAL_RIDES";
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(30.0, 2, rideCategory);
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserId_ShouldReturnInvoice() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides1 = { new Ride(2.0, 5),
                new Ride(0.1, 1),
                new Ride(2.0,5)
        };
        Ride[] rides2 = { new Ride(5.0, 5),
                new Ride(0.1, 8)
        };
        Map<Integer, Ride[]> usersRides = new HashMap<Integer, Ride[]>();
        int userId1 = 101;
        usersRides.put(userId1, rides1);
        int userId2 = 102;
        usersRides.put(userId2,rides2);
        RideRepository rideRepository = new RideRepository();
        rideRepository.setUserRides(usersRides);
        InvoiceService invoiceService = new InvoiceService();
        Ride[] listOfRides = invoiceService.getListOfRides(userId1);
        String rideCategory = "NORMAL_RIDES";
        InvoiceSummary expectedInvoice = new InvoiceSummary(55.0, 3, rideCategory);
        InvoiceSummary invoice = invoiceGenerator.calculateFare(listOfRides);
        Assert.assertEquals(expectedInvoice, invoice);
    }

    @Test
    public void givenRideCategory_ShouldReturnFareAsPerCategory() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        String rideCategory = "PREMIUM_RIDES";
        double fare = invoiceGenerator.calculateFare(distance, time, rideCategory);
        Assert.assertEquals(40, fare,0.0);
    }
}
