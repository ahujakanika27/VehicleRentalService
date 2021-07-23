package com.kanahuja.main.model.reservation;

import com.kanahuja.main.model.vehicle.HireableVehicle;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class VehicleInventory {
    private String id;
    private String reservationId;
    private LocalDateTime reservationDate;
    private ReservationStatus status;
    private LocalDateTime fromDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private HireableVehicle vehicle;
    private VehicleReservationType vehicleReservationType;

    public VehicleInventory() {
    }
    public VehicleInventory(HireableVehicle hireableVehicle) {
        this.id = UUID.randomUUID().toString();
        this.vehicle = hireableVehicle;
    }
}