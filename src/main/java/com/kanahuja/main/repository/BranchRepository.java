package com.kanahuja.main.repository;

import com.kanahuja.main.model.common.Branch;
import com.kanahuja.main.model.reservation.VehicleHourlyCosts;
import com.kanahuja.main.model.vehicle.VehicleType;

import java.util.*;
import java.util.stream.Collectors;

public class BranchRepository {

    private static BranchRepository INSTANCE;

    private BranchRepository() {
    }

    public static synchronized BranchRepository getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new BranchRepository();
        }

        return INSTANCE;
    }

    public static Map<String, Branch> branchMap = new HashMap<>();
    public static List<String> branchNameList = new ArrayList<>();

    public void addBranch(String branchName){
        Branch b1 = new Branch(branchName, UUID.randomUUID().toString(), new VehicleHourlyCosts());
        branchMap.putIfAbsent(branchName,b1);
    }

    public void allocatePriceToBranch(String branchName, VehicleType vt,  int price){
         branchMap.get(branchName).setVhCost(new VehicleHourlyCosts(vt, price));
    }

    public List<String> getBranchNameList(){
        branchNameList = new ArrayList<>(branchMap.keySet());
        return branchNameList;
    }


    public List<Branch> getBranchListWithVehicleTypeAndPrice(VehicleType vt){
        List<Branch> bList = branchMap.values().stream().filter(branch -> branch.getVhCost().getVt() == vt).sorted(Comparator.comparingInt(e -> e.getVhCost().getPrice())).collect(Collectors.toList());
        return bList;
    }

}
