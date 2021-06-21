package com.mbrady.oortfreight.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Component
public class Bluprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shipyardId;

    @NonNull
    private String shipClass;

    @NonNull
    private Long shipPrice;

    public Bluprint() {
        shipClass = "default";
        shipPrice = 1l;
    }

    public Bluprint(String sClass, Long sPrice) {
        shipClass = sClass;
        shipPrice = sPrice;
    }
}
