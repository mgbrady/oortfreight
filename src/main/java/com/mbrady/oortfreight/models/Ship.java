package com.mbrady.oortfreight.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import lombok.NonNull;

@Entity
@Component
public class Ship implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shipId;

    @NonNull
    private String shipName;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Player shipOwner;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Blueprint shipClass;

    public void setShipClass(Blueprint shipClass) {
        this.shipClass = shipClass;
    }

    public Blueprint getShipClass() {
        return shipClass;
    }

    public void setShipOwner(Player player) {
        shipOwner = player;
    }

    public Player getShipOwner() {
        return shipOwner;
    }

    public void setShipName(String name) {
        shipName = name;
    }

    public String getShipName() {
        return shipName;
    }
}