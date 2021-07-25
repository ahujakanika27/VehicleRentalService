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


// CITY -> List(Branch)-> branch (vt -> List(Vehicles, hourly cost))

// vehicle class should have getCosts based on branch and parameters of cost
// branch repository

// add branch -> branchId

// allocate Price (branchName, vt, price) -> check branch exists or not -> vehicle Type (update cost in the hourly map)

// add vehicle(vehicleId, vt, branch) -> check the vt based on branch -> get list of vehicles and see if vehicleId exists, if not then add it.

/* book vehicle(vt, start , end) -> from all branches fetch the list of vehicles -> search that vehicleId in the reservation List -> from the list check if any reservation exists in that timestamp, sort on the basis of price.Update reservation.

Reservation -> VehicleDetails + Timeslot + Booked */

/* viewInventory (start, end) -> list of branch -> branch -> vehicles -> vehicleID -> List of reservations -> if Booked else available
OR
reservation -> look for all vehicles booked in that time slot ->  Set(vehicleId) -> List(branch) -> vt -> list(vehicle) -> vehicleID -> CHECK in set of booked Ids -> if it does not exist then mark it as AVAILABLE
*/
