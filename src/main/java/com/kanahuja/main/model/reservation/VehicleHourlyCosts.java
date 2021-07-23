package com.kanahuja.main.model.reservation;

import com.kanahuja.main.model.vehicle.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class VehicleHourlyCosts {
    public static Map<VehicleType, Double> vehicleHourlyCost = new HashMap<>();

    static {
        vehicleHourlyCost.put(VehicleType.HATCHBACK, 50.0);
        vehicleHourlyCost.put(VehicleType.SEDAN, 150.0);
        vehicleHourlyCost.put(VehicleType.SUV, 200.0);
    }
}