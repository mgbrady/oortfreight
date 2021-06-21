package com.mbrady.oortfreight.dao;

import java.util.List;
import java.util.Optional;

import com.mbrady.oortfreight.models.Contract;
import com.mbrady.oortfreight.models.Player;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepo extends JpaRepository<Contract, Long> {
    Optional<List<Contract>> findByContractPlayer(Player player);
    
}