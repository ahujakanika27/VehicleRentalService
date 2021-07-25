package com.kanahuja.main.service;

import com.kanahuja.main.exceptions.BranchNotFoundException;
import com.kanahuja.main.exceptions.InvalidVehicleTypeException;
import com.kanahuja.main.exceptions.VehicleBookedException;
import com.kanahuja.main.model.common.Branch;
import com.kanahuja.main.model.vehicle.HireableVehicle;
import com.kanahuja.main.model.vehicle.VehicleStatus;
import com.kanahuja.main.repository.BranchRepository;
import com.kanahuja.main.repository.VehicleRepository;
import com.kanahuja.main.repository.VehicleReservationRepository;
import com.kanahuja.main.model.reservation.ReservationStatus;
import com.kanahuja.main.model.reservation.VehicleReservation;
import com.kanahuja.main.model.reservation.VehicleReservationType;
import com.kanahuja.main.model.vehicle.VehicleType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


public class UserServiceImpl implements UserService{
    VehicleReservationRepository vehicleReservationRepository = VehicleReservationRepository.getInstance();
    BranchRepository branchRepository = BranchRepository.getInstance();
    VehicleRepository  vehicleRepository= VehicleRepository.getInstance();

    @Override
    public void addBranch(String branchName) {
        branchRepository.addBranch(branchName);
        System.out.println("branch added to repository :"+BranchRepository.branchMap.get(branchName).toString());
    }
    @Override
    public void allocatePrice(String branchName, VehicleType vt, int price) throws Exception{
        if(!branchRepository.getBranchNameList().contains(branchName))
            throw new BranchNotFoundException("Branch :"+branchName+ "does not exist");
        else if(!vehicleRepository.checkVehicleTypeInBranch(vt, branchName))
            throw new InvalidVehicleTypeException("VehicleType: "+vt+"does not exist in branch :"+branchName);
        else{
            branchRepository.allocatePriceToBranch(branchName, vt, price);
            System.out.println("price :"+price+" allocated to branch :"+BranchRepository.branchMap.get(branchName).toString());
        }
    }

    @Override
    public void addVehicle(String vehicleId, VehicleType vt, String branchName) throws BranchNotFoundException {
        if(!branchRepository.getBranchNameList().contains(branchName))
            throw new BranchNotFoundException("Branch :"+branchName+ "does not exist");
        else{
            vehicleRepository.addVehicle(new HireableVehicle(vehicleId,vt, branchName));
            System.out.println("vehicle :"+vt+" added to vehicle repository :"+VehicleRepository.vehicleMap.get(vehicleId).toString());
        }
    }

    @Override
    public VehicleReservation bookVehicle(VehicleType vt, LocalDateTime fromDate, LocalDateTime toDate) throws  Exception{
        if(!vehicleRepository.checkVehicleTypeInInventory(vt))
            throw new InvalidVehicleTypeException("Vehicle Type :"+vt+"does not exist in the inventory");
        else if(checkVehicleReservationByTypeAndTime(vt, fromDate, toDate)) {
            throw new VehicleBookedException("NO "+vt.toString().toUpperCase()+" AVAILABLE");
        }
        else{
            Branch br = branchRepository.getBranchListWithVehicleTypeAndPrice(vt).get(0);
            HireableVehicle hv = VehicleRepository.vehicles.stream().filter(hireableVehicle ->
                    hireableVehicle.getBranchName().equalsIgnoreCase(br.getName())).collect(Collectors.toList()).get(0);
            vehicleRepository.changeStatusToBooked(hv);
            System.out.println(hv.getId()+" from "+hv.getBranchName()+" Booked");
            return createVehicleReservation(fromDate, toDate, vt, hv.getId());
        }
    }

    @Override
    public void viewInventory(LocalDateTime fromDate, LocalDateTime toDate){
            List<String> bookedVehicleIds = new ArrayList<>();
            // List of Booked Reservations
            List<VehicleReservation> BookedVehicleReservations = VehicleReservationRepository.vehicleReservations.stream()
                .filter(vr -> checkReservationsBetweenDates(vr, fromDate, toDate)).collect(Collectors.toList());

            // List of Available Vehicles, not BOOKED
            List<HireableVehicle> availableVehicles = VehicleRepository.vehicles.stream().filter(hireableVehicle ->
                    hireableVehicle.getVehicleStatus().equals(VehicleStatus.AVAILALBE)).collect(Collectors.toList());

            for(String branch : branchRepository.getBranchNameList()){
                System.out.println("Branch: "+branch);
                for(VehicleReservation vr : BookedVehicleReservations){
                    String vehicleId = vr.getAllocatedVehicleId();
                    if(VehicleRepository.vehicleMap.containsKey(vehicleId) &&
                            VehicleRepository.vehicleMap.get(vehicleId).getBranchName().equalsIgnoreCase(branch))
                        System.out.println(""+vr.getVehicleType()+" "+vr.getAllocatedVehicleId()+" Booked");
                }
                for(HireableVehicle hv : availableVehicles){
                    if(hv.getBranchName().equalsIgnoreCase(branch))
                        System.out.println(""+hv.getVehicleType()+" "+hv.getId()+" Available");
                }
            }
    }

    private Boolean checkReservationsBetweenDates(VehicleReservation vr, LocalDateTime fromDate, LocalDateTime toDate){
        if(fromDate.isBefore(vr.getReturnDate()))
            return true;
        return false;
    }


    // vr 10:30==========10:45
    //      10:31===============10: 55

    private Boolean checkVehicleReservationByTypeAndTime(VehicleType vt, LocalDateTime fromDate, LocalDateTime toDate){
        return VehicleReservationRepository.vehicleReservations.stream().anyMatch(vehicleReservation ->
                vehicleReservation.getVehicleType() == vt && checkDateAndTime(vehicleReservation, fromDate,toDate));
    }

    // booked -> 3- 6 , requested -> 4-5
    private Boolean checkDateAndTime(VehicleReservation vh, LocalDateTime fromDate, LocalDateTime toDate){
        if((fromDate.isBefore(vh.getReturnDate()) && fromDate.isAfter(vh.getFromDate())) || (toDate.isBefore(vh.getReturnDate()) && toDate.isAfter(vh.getFromDate())))
            return false;
        return true;
    }

    private VehicleReservation createVehicleReservation(LocalDateTime fromDate, LocalDateTime toDate, VehicleType vt, String vehicleId){
        VehicleReservation vehicleReservation = new VehicleReservation();
        vehicleReservation.setReservationId(UUID.randomUUID().toString());
        vehicleReservation.setFromDate(fromDate);
        vehicleReservation.setReturnDate(toDate);
        vehicleReservation.setStatus(ReservationStatus.CONFIRMED);
        vehicleReservation.setVehicleReservationType(VehicleReservationType.HOURLY);
        vehicleReservation.setVehicleType(vt);
        vehicleReservation.setAllocatedVehicleId(vehicleId);
        return reserve(vehicleReservation);
    }

    private VehicleReservation reserve(VehicleReservation vehicleReservation) {
        VehicleReservationRepository.vehicleReservationMap
                .put(vehicleReservation.getReservationId(), vehicleReservation);
        VehicleReservationRepository.vehicleReservations.add(vehicleReservation);
        return vehicleReservation;
    }


}

