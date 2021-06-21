package com.mbrady.oortfreight.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NonNull;

@Data
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
    private Bluprint shipClass;

    public void setShipOwner(Player player) {
        shipOwner = player;
    }
}