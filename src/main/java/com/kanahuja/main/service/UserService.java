package com.kanahuja.main.service;

import com.kanahuja.main.exceptions.BranchNotFoundException;
import com.kanahuja.main.model.reservation.VehicleReservation;
import com.kanahuja.main.model.vehicle.VehicleType;

import java.time.LocalDateTime;


public interface UserService {
    void addBranch(String branchName) throws Exception;
    void allocatePrice(String branchName, VehicleType vt, int price) throws Exception;
    void addVehicle(String vehicleId, VehicleType vt, String branchName) throws BranchNotFoundException;
    VehicleReservation bookVehicle(VehicleType vt, LocalDateTime fromDate, LocalDateTime toDate) throws Exception;
    void viewInventory(LocalDateTime fromDate, LocalDateTime toDate);
}
