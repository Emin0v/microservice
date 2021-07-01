package com.company.model;

import lombok.Getter;

@Getter
public enum PriorityType {

    URGENT("URGENT"),
    LOW("LOW"),
    HIGH("HIGH");

    private String label;

    PriorityType(String label){
        this.label = label;
    }
}
