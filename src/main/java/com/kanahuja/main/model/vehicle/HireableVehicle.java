package com.kanahuja.main.model.vehicle;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class HireableVehicle {
    private String id;
    private VehicleType vehicleType;
    private String branchName;
    private VehicleStatus vehicleStatus = VehicleStatus.AVAILALBE;

    public HireableVehicle(String id, VehicleType vehicleType, String branchName) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.branchName = branchName;
    }

    @Override
    public String toString() {
        return String.format(id + " branch name: " + branchName+ " for type: "+vehicleType);
    }
}
