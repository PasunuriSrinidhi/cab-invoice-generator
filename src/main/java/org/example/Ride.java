package com.example;

public class Ride {
    int user_id;
    double distance;
    double time;
    RideType rideType;

    public Ride(int user_id, double distance, double time, RideType rideType) {
        this.user_id = user_id;
        this.distance = distance;
        this.time = time;
        this.rideType = rideType;

        // adding the ride to ride repository
        RideRepository.addRide(user_id, this);
    }
}
