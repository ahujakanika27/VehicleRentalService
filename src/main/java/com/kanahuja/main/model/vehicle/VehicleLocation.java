package com.kanahuja.main.model.vehicle;

import com.kanahuja.main.model.common.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleLocation {
    private String locationId;
    private Address address;
}