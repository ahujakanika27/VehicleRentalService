package com.kanahuja.main.repository;

import com.kanahuja.main.model.vehicle.HireableVehicle;
import com.kanahuja.main.model.vehicle.VehicleStatus;
import com.kanahuja.main.model.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleRepository {
    private static VehicleRepository INSTANCE;

    private VehicleRepository() {
    }

    public static synchronized VehicleRepository getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new VehicleRepository();
        }

        return INSTANCE;
    }

    public static Map<String, HireableVehicle> vehicleMap = new HashMap<>();
    public static List<HireableVehicle> vehicles = new ArrayList<>();

    public HireableVehicle addVehicle(HireableVehicle hireableVehicle) {
        vehicleMap.putIfAbsent(hireableVehicle.getId(), hireableVehicle);
        vehicles.add(hireableVehicle);
        return hireableVehicle;
    }

    public void changeStatusToBooked(HireableVehicle hireableVehicle){
        vehicleMap.get(hireableVehicle.getId()).setVehicleStatus(VehicleStatus.BOOKED);
    }

    public Boolean checkVehicleTypeInBranch(VehicleType vt, String branchName){
        for (Map.Entry<String, HireableVehicle> entry : vehicleMap.entrySet()) {
            if(entry.getValue().getVehicleType() == vt && entry.getValue().getBranchName().equalsIgnoreCase(branchName))
                return true;
        }
        return false;
    }

    public Boolean checkVehicleTypeInInventory(VehicleType vt){
        for (Map.Entry<String, HireableVehicle> entry : vehicleMap.entrySet()) {
            if(entry.getValue().getVehicleType() == vt)
                return true;
        }
        return false;
    }

}
