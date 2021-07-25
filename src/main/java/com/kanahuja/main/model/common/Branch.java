package com.kanahuja.main.model.common;

import com.kanahuja.main.model.reservation.VehicleHourlyCosts;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Branch {
    private String name;
    private String branchId;
    private VehicleHourlyCosts vhCost;

    public Branch(String name, String branchId, VehicleHourlyCosts cost) {
        this.name = name;
        this.branchId = branchId;
        this.vhCost = cost;
    }

    @Override
    public String toString() {
        return String.format(name + " Hourly Cost: " + vhCost.getPrice()+ " for type: "+vhCost.getVt());
    }
}