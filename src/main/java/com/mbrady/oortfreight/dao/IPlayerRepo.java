package com.mbrady.oortfreight.dao;

import java.util.Optional;

import com.mbrady.oortfreight.models.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayerRepo extends JpaRepository<Player, Long>{
    Optional<Player> findByPlayerName(String playerName);
}
