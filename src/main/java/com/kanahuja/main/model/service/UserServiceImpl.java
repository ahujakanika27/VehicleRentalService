package com.kanahuja.main.model.service;

import com.kanahuja.main.model.repository.VehicleInventoryRepository;
import com.kanahuja.main.model.repository.VehicleRepository;
import com.kanahuja.main.model.repository.VehicleReservationRepository;
import com.kanahuja.main.model.reservation.VehicleReservation;
import com.kanahuja.main.model.vehicle.HireableVehicle;
import com.kanahuja.main.model.vehicle.VehicleStatus;
import com.kanahuja.main.model.vehicle.VehicleType;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class UserServiceImpl extends UserService{
    VehicleReservationRepository vehicleReservationRepository = new
            VehicleReservationRepository();
    VehicleInventoryRepository vehicleInventoryRepository = new VehicleInventoryRepository();
    HashMap<String, String> branchMap = new HashMap<>();

    @Override
    public void addBranch(String branchName){
        branchMap.putIfAbsent("DELHI", branchName);
    }

    @Override
    public void allocatePrice(String branchName, VehicleType vt, Double price){

    }
    @Override
    public VehicleReservation bookVehicle(VehicleType vt, LocalDateTime fromDate, LocalDateTime toDate){
    }


}

