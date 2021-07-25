package com.kanahuja.main.model.reservation;

import com.kanahuja.main.model.vehicle.VehicleType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VehicleReservation {
    private String reservationId;
    private LocalDateTime reservationDate;
    private ReservationStatus status;
    private LocalDateTime fromDate;
    private LocalDateTime returnDate;
    private String allocatedVehicleId;
    private VehicleType vehicleType;
    private VehicleReservationType vehicleReservationType;
}