package com.kanahuja.main.model.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Branch {
    private String name;
    private String branchId;

    public Branch(String name, String branchId) {
        this.name = name;
        this.branchId = branchId;
    }
}
