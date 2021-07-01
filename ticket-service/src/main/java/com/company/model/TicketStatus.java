package com.company.model;

import lombok.Getter;

@Getter
public enum TicketStatus {

    OPEN("OPEN"),
    IN_PROGRESS("IN_PROGRESS"),
    RESOLVED("RESOLVED"),
    CLOSED("CLOSED");

    private String label;

    TicketStatus(String label){
        this.label = label;
    }

}
