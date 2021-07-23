package com.kanahuja.main.service;

import com.kanahuja.main.model.vehicle.HireableVehicle;

public interface VehicleInterface {
    HireableVehicle getVehicleById(String id);
    HireableVehicle addVehicle(HireableVehicle hireableVehicle);
}
