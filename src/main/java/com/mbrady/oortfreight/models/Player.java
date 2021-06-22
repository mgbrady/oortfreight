package com.mbrady.oortfreight.models;

import java.io.Serializable;

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
public class Player implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;

    @NonNull
    private String playerName;

    @NonNull
    private String playerRole;

    @NonNull
    private String password;

    @NonNull
    private Long playerMonies = 1000000l;

    public Player() {
        playerName = "default";
        password = "default";
        playerRole = "default";
    }

    public Player(String pName, String pRole, String password) {
        playerName = pName;
        playerRole = pRole;
        this.password = password;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String name) {
        playerName = name;
    }
}