package com.kanahuja.main.service;

import com.kanahuja.main.repository.VehicleInventoryRepository;
import com.kanahuja.main.model.vehicle.HireableVehicle;
import com.kanahuja.main.model.vehicle.VehicleType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleSearchServiceImpl implements VehicleSearchService {

    @Override
    public List<HireableVehicle> search(VehicleType vehicleType, String branch,
                                        LocalDateTime fromDate, LocalDateTime toDate) {
        List<HireableVehicle> hireableVehicles =
                VehicleInventoryRepository.vehicleInventoryList
                        .stream()
                        .filter(vehicleInventory ->
                                vehicleInventory.getVehicle().getVehicleType() == vehicleType
                                        && vehicleInventory.getVehicle().getBranchName()
                                        .equalsIgnoreCase(branch)
                                        && !(
                                        (vehicleInventory.getDueDate() != null &&
                                                fromDate.isBefore(vehicleInventory.getDueDate()))
                                                && (vehicleInventory.getFromDate() != null
                                                && toDate.isAfter(vehicleInventory.getFromDate())))
                        ).map(vehicleInventory -> vehicleInventory.getVehicle())
                        .collect(Collectors.toList());
        return hireableVehicles;
    }
}
