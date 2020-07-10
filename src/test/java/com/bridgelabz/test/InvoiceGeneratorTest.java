package com.bridgelabz.test;

import com.bridgelabz.service.InvoiceGenerator;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTheTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, totalFare,0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double totalFare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, totalFare,0.0);
    }
}
