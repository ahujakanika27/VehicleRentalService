package com.kanahuja.main.repository;

import com.kanahuja.main.model.reservation.VehicleReservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleReservationRepository {

    private static VehicleReservationRepository INSTANCE;

    private VehicleReservationRepository() {
    }

    public static synchronized VehicleReservationRepository getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new VehicleReservationRepository();
        }

        return INSTANCE;
    }

    public static Map<String, VehicleReservation> vehicleReservationMap =
            new HashMap<>();
    public static List<VehicleReservation> vehicleReservations = new ArrayList<>();





}
