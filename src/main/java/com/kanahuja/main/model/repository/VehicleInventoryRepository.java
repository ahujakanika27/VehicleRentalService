package com.kanahuja.main.model.repository;

import com.kanahuja.main.model.reservation.VehicleInventory;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventoryRepository {
    public static List<VehicleInventory> vehicleInventoryList = new ArrayList<>();

    public VehicleInventory addToInventory(VehicleInventory vehicleInventory) {
        vehicleInventoryList.add(vehicleInventory);
        return vehicleInventory;
    }
}