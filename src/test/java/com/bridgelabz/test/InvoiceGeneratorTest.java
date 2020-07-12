package com.bridgelabz.test;

import com.bridgelabz.model.Ride;
import com.bridgelabz.repository.RideRepository;
import com.bridgelabz.service.*;
import com.bridgelabz.utility.InvoiceService;
import com.bridgelabz.utility.InvoiceSummary;
import com.bridgelabz.utility.RideCategory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class InvoiceGeneratorTest {
    InvoiceGenerator invoiceGenerator = null;
    @Before
    public void setUp() throws Exception {
        invoiceGenerator = new InvoiceGenerator();
    }
    @Test
    public void givenDistanceAndTime_ShouldReturnTheTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time, RideCategory.BASIC);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time, RideCategory.BASIC);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(30.0, 2, RideCategory.BASIC);
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserId_ShouldReturnInvoice() {
        Ride[] rides1 = {new Ride(2.0, 5),
                new Ride(0.1, 1),
                new Ride(2.0, 5)
        };
        Ride[] rides2 = {new Ride(5.0, 5),
                new Ride(0.1, 8)
        };
        Map<Integer, Ride[]> usersRides = new HashMap<>();
        int userId1 = 101;
        usersRides.put(userId1, rides1);
        int userId2 = 102;
        usersRides.put(userId2, rides2);
        RideRepository rideRepository = new RideRepository();
        rideRepository.setUserRides(usersRides);
        InvoiceService invoiceService = new InvoiceService();
        Ride[] listOfRides = invoiceService.getListOfRides(userId1);
        InvoiceSummary expectedInvoice = new InvoiceSummary(55.0, 3, RideCategory.BASIC);
        InvoiceSummary invoice = invoiceGenerator.calculateFare(listOfRides);
        Assert.assertEquals(expectedInvoice, invoice);
    }

    @Test
    public void givenRideCategory_ShouldReturnFareAsPerCategory() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time, RideCategory.PREMIUM);
        Assert.assertEquals(40, fare, 0.0);
    }
}
