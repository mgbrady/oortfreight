package com.mbrady.oortfreight.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class Blueprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shipyardId;

    @NonNull
    private String shipClass;

    @NonNull
    private Long shipPrice;

    public Blueprint() {
        shipClass = "default";
        shipPrice = 1l;
    }
}
