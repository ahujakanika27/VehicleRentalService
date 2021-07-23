package com.kanahuja.main.model.reservation;

import com.kanahuja.main.model.vehicle.VehicleType;
import lombok.Getter;
import lombok.Setter;

import com.kanahuja.main.model.common.Address;
import java.time.LocalDateTime;

@Getter
@Setter
public class VehicleReservation {
    private String reservationId;
    private String usrId;
    private LocalDateTime reservationDate;
    private ReservationStatus status;
    private LocalDateTime fromDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private Address pickupLocation;
    private Address dropLocation;
    private String accocatedVehicleId;
    private VehicleType vehicleType;
    private VehicleReservationType vehicleReservationType;
}