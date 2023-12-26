package com.example;

public class Invoice {
    int rides;
    double fare;
    double avg_fare;

    public Invoice(int rides, double fare, double avg_fare) {
        this.rides = rides;
        this.fare = fare;
        this.avg_fare = avg_fare;
    }

    public int getRides() {
        return this.rides;
    }

    public double getFare() {
        return this.fare;
    }

    public double getAvgFare() {
        return this.avg_fare;
    }
}
