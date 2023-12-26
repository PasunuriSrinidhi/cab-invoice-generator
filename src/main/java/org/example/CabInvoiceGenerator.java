package com.example;

import java.util.ArrayList;

public class CabInvoiceGenerator {
    static final double FARE_PER_KM = 10.0;
    static final double FARE_PER_MIN = 1.0;
    static final double MINIMUM_FARE = 5.0;

    // method to calculate fare
    public double calculateFare(double distance, double time) {
        double fare = distance * FARE_PER_KM + time * FARE_PER_MIN;
        return Math.max(fare, MINIMUM_FARE);
    }

    // method to calculate fare for multiple rides
    public double calculateFare(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            double fare = ride.distance * ride.rideType.FARE_PER_KM + ride.time * ride.rideType.FARE_PER_MIN;
            totalFare += Math.max(fare, ride.rideType.MINIMUM_FARE);
        }
        return totalFare;
    }

    // method to generate Invoice for rides
    public Invoice generateInvoice(Ride[] rides) {
        int num_of_rides = rides.length;
        double totalFare = calculateFare(rides);
        double avgFare = totalFare / num_of_rides;
        return new Invoice(num_of_rides, totalFare, avgFare);
    }

    // method to generate Invoice for particular user
    public Invoice generateInvoiceForUser(int user_id) {
        ArrayList<Ride> ridesList = RideRepository.getAllRides(user_id);
        int num_of_rides = ridesList.size();
        Ride[] rides = new Ride[num_of_rides];
        for (int i = 0; i < num_of_rides; i++) {
            rides[i] = ridesList.get(i);
        }
        return this.generateInvoice(rides);
    }
}
