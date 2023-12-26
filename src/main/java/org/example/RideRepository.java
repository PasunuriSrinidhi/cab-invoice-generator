package com.example;

import java.util.ArrayList;
import java.util.HashMap;

public class RideRepository {
    static HashMap<Integer, ArrayList<Ride>> rideRepository = new HashMap<>();

    public static void addRide(int user_id, Ride ride) {
        ArrayList<Ride> ridesList;
        if (rideRepository.containsKey(user_id)) {
            ridesList = rideRepository.get(user_id);
        } else {
            ridesList = new ArrayList<>();
        }
        ridesList.add(ride);
        rideRepository.put(user_id, ridesList);
    }

    public static ArrayList<Ride> getAllRides(int user_id) {
        return rideRepository.containsKey(user_id) ? rideRepository.get(user_id) : new ArrayList<>();
    }
}
