package com.kanahuja.main.model.vehicle;

import com.kanahuja.main.model.common.Branch;
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
