package com.mbrady.oortfreight.services;

import java.util.List;
import java.util.Optional;

import com.mbrady.oortfreight.dao.IPlayerRepo;
import com.mbrady.oortfreight.models.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class PlayerService {
    @Autowired
    IPlayerRepo playerRepo;

    public List<Player> getAllPlayers() {
        return playerRepo.findAll();
    }

    public Optional<Player> findByName(String name) {
        return playerRepo.findByPlayerName(name);
    }

    public Player getPlayerById(Long id) {
        return playerRepo.getById(id);
    }

    public Player savePlayer(Player player) {
        return playerRepo.save(player);
    }

    public void removePlayer(Long id) {
        playerRepo.deleteById(id);
    }
}
