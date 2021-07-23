package com.kanahuja.main.model.vehicle;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public abstract class HireableVehicle {
    private String id;
    private VehicleStatus vehicleStatus;
    private VehicleType vehicleType;
    private String branchName;
}
