package com.mbrady.oortfreight.services;

import java.util.List;
import java.util.Optional;

import com.mbrady.oortfreight.dao.IPlayerRepo;
import com.mbrady.oortfreight.dao.IShipRepo;
import com.mbrady.oortfreight.models.Player;
import com.mbrady.oortfreight.models.Ship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShipService {
    @Autowired
    IShipRepo shipRepo;

    @Autowired
    IPlayerRepo playerRepo;

    public Optional<List<Ship>> findShipsByPlayer(Player player) {
        return shipRepo.findByShipOwner(player);
    }

    public void deleteShip(Ship ship) {
        shipRepo.delete(ship);
    }
}