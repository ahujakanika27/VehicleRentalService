package com.kanahuja.main.service;

import com.kanahuja.main.model.vehicle.HireableVehicle;
import com.kanahuja.main.model.vehicle.VehicleType;

import java.time.LocalDateTime;
import java.util.List;

public interface VehicleSearchService {
    List<HireableVehicle> search(VehicleType vehicleType, String branch,
                                 LocalDateTime fromDate, LocalDateTime toDate);
}

