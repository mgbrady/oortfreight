package com.mbrady.oortfreight.dao;

import java.util.Optional;

import com.mbrady.oortfreight.models.Player;
import com.mbrady.oortfreight.models.Ship;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IShipRepo extends JpaRepository<Ship, Long> {
    Optional<Ship> findByShipOwner(Player owner);
}
