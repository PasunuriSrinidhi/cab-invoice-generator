import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.*;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();

    // test calculate fare
    @Test
    public void givenDistanceAndTime_Calculate_ReturnFare() {
        double fare = cabInvoiceGenerator.calculateFare(10, 20);
        assertEquals(120, fare);
    }

    // test minimum fare
    @Test
    public void givenDistanceAndTime_Calculate_ReturnMinimumFare() {
        double fare = cabInvoiceGenerator.calculateFare(0, 0);
        assertEquals(5, fare);
    }

    // test for multiple rides
    @Test
    public void givenMultipleRides_Calculate_ReturnAggregateTotal() {
        Ride[] rides = { new Ride(1, 5, 10, RideType.NORMAL), new Ride(1, 10, 20, RideType.NORMAL),
                new Ride(1, 8, 15, RideType.NORMAL) };
        double totalFare = cabInvoiceGenerator.calculateFare(rides);
        assertEquals(275, totalFare);
    }

    // test for invoice
    @Test
    public void givenDistanceAndTime_Calculate_ReturnNoofRidesAndTotalFareAndAvgFare() {
        Ride[] rides = { new Ride(1, 5, 10, RideType.NORMAL), new Ride(1, 10, 20, RideType.NORMAL),
                new Ride(1, 8, 15, RideType.NORMAL) };
        Invoice invoice = cabInvoiceGenerator.generateInvoice(rides);
        assertEquals(3, invoice.getRides());
        assertEquals(275, invoice.getFare());
        assertEquals(91.66666666666667, invoice.getAvgFare());
    }

    // testing for invoice fetched by user_id
    @Test
    public void givenUserId_GetListOfRides_ReturnInvoice() {
        // creating some new rides
        new Ride(1, 5, 10, RideType.NORMAL);
        new Ride(1, 10, 20, RideType.NORMAL);
        new Ride(2, 8, 15, RideType.NORMAL);

        Invoice invoice = cabInvoiceGenerator.generateInvoiceForUser(1);
        assertEquals(2, invoice.getRides());
        assertEquals(180, invoice.getFare());
        assertEquals(90, invoice.getAvgFare());
    }

    // testing by ride type
    @Test
    public void givenNormalAndPremium_Calculate_ReturnTypesofRides() {
        Ride[] rides = { new Ride(1, 5, 10, RideType.NORMAL), new Ride(1, 10, 20, RideType.NORMAL),
                new Ride(1, 8, 15, RideType.PREMIUM) };
        Invoice invoice = cabInvoiceGenerator.generateInvoice(rides);
        assertEquals(3, invoice.getRides());
        assertEquals(330, invoice.getFare());
        assertEquals(110, invoice.getAvgFare());
    }
}
