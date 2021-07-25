package com.kanahuja.main;

import com.kanahuja.main.model.vehicle.VehicleType;
import com.kanahuja.main.service.UserServiceImpl;

import java.time.LocalDateTime;

public class ApplicationMain {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to the Vehical Rental application");

        UserServiceImpl impl = new UserServiceImpl();
        impl.addBranch("Vasant Vihar");
        impl.addVehicle("id1", VehicleType.SEDAN, "Vasant Vihar");
        impl.addVehicle("id2", VehicleType.HATCHBACK, "Vasant Vihar");
        impl.allocatePrice("Vasant Vihar", VehicleType.SEDAN, 100);
        impl.bookVehicle(VehicleType.SEDAN, LocalDateTime.now(), LocalDateTime.of(2021, 7, 25, 23, 27));
        impl.viewInventory(LocalDateTime.now(),LocalDateTime.of(2021, 7, 25, 23, 57));
    }
}
