package com.kanahuja.main.model.service;

import com.kanahuja.main.model.repository.VehicleRepository;
import com.kanahuja.main.model.reservation.VehicleInventory;
import com.kanahuja.main.model.vehicle.HireableVehicle;
import com.kanahuja.main.model.repository.VehicleInventoryRepository;

public class VehicleServiceImpl implements VehicleInterface{
    VehicleRepository vehicleRepository = new VehicleRepository();

    @Override
    public HireableVehicle getVehicleById(String id) {
        return VehicleRepository.vehicleMap.get(id);
    }

    @Override
    public HireableVehicle addVehicle(HireableVehicle hireableVehicle) {
        addToInventory(hireableVehicle);
        return vehicleRepository.addVehicle(hireableVehicle);
    }

    private void addToInventory(HireableVehicle hireableVehicle) {
        VehicleInventory vehicleInventory = new VehicleInventory(hireableVehicle);
        VehicleInventoryRepository vehicleInventoryRepository = new VehicleInventoryRepository();
        vehicleInventoryRepository.addToInventory(vehicleInventory);
    }
}
