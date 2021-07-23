package com.kanahuja.main.service;

import com.kanahuja.main.model.common.Branch;
import com.kanahuja.main.model.reservation.VehicleReservation;
import com.kanahuja.main.model.vehicle.VehicleType;

import java.time.LocalDateTime;


public interface UserService {
    void addBranch(String branchName);
    void allocatePrice(String branchName, VehicleType vt, Double price);
    VehicleReservation bookVehicle(VehicleType vt, LocalDateTime fromDate, LocalDateTime toDate);
}
