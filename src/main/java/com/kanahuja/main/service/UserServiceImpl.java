package com.kanahuja.main.service;

import com.kanahuja.main.repository.VehicleInventoryRepository;
import com.kanahuja.main.repository.VehicleReservationRepository;
import com.kanahuja.main.model.reservation.ReservationStatus;
import com.kanahuja.main.model.reservation.VehicleReservation;
import com.kanahuja.main.model.reservation.VehicleReservationType;
import com.kanahuja.main.model.vehicle.VehicleType;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;


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
        VehicleReservation vehicleReservation = new VehicleReservation();
        vehicleReservation.setReservationId(UUID.randomUUID().toString());
        vehicleReservation.setFromDate(fromDate);
        vehicleReservation.setReturnDate(toDate);
        vehicleReservation.setDueDate(LocalDateTime.now().plusHours(2));
        vehicleReservation.setStatus(ReservationStatus.ACTIVE);
        vehicleReservation.setVehicleReservationType(VehicleReservationType.HOURLY);
        vehicleReservation.setVehicleType(vt);
        vehicleReservation.setVehicleReservationType(VehicleReservationType.HOURLY);
        return vehicleReservation;
    }


}

