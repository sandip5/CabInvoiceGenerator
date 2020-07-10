package com.bridgelabz.test;

import com.bridgelabz.service.InvoiceGenerator;
import com.bridgelabz.service.InvoiceSummary;
import com.bridgelabz.service.Ride;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTheTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare,0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = { new Ride(2.0, 5),
                         new Ride(0.1, 1)
                        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(30.0, 2);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}
