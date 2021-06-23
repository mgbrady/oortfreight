package com.mbrady.oortfreight.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Entity
public class Contract implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractId;

    @NonNull
    private String contractName;

    @NonNull
    private Long contractAward;

    @ManyToOne(fetch = FetchType.LAZY)
    private Player contractPlayer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ship contractShip;

    public Contract() {
        contractName = "default";
        contractAward = 10000l;
    }

    public Contract(String name) {
        this();
        contractName = name;
    }

    public Contract(String cName, Long cAward) {
        contractName = cName;
        contractAward = cAward;
    }

    public void setContractPlayer(Player player) {
        contractPlayer = player;
    }

    public void setContractShip(Ship ship) {
        contractShip = ship;
    }

    public String getContractName() {
        return contractName;
    }

    public Long getContractAward() {
        return contractAward;
    }
}
