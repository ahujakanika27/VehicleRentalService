package com.kanahuja.main.model.reservation;

import com.kanahuja.main.model.vehicle.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleHourlyCosts {
    private VehicleType vt;
    private int price;

    public VehicleHourlyCosts() {
    }

    public VehicleHourlyCosts(VehicleType vt, int price) {
        this.vt = vt;
        this.price = price;
    }
}