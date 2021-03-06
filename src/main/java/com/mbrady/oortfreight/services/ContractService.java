package com.mbrady.oortfreight.services;

import java.util.List;
import java.util.Optional;

import com.mbrady.oortfreight.dao.IContractRepo;
import com.mbrady.oortfreight.models.Contract;
import com.mbrady.oortfreight.models.Player;
import com.mbrady.oortfreight.models.Ship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ContractService {
    @Autowired
    IContractRepo contractRepo;

    public List<Contract> getAllContracts() {
        return contractRepo.findAll();
    }

    public void saveContract(Contract contract) {
        contractRepo.save(contract);
    }

    public Optional<List<Contract>> findAvailableContracts() {
        return contractRepo.findByContractPlayerIsNull();
    }

    public Optional<List<Contract>> findByPlayer(Player player) {
        return contractRepo.findByContractPlayer(player);
    }

    public void addPlayerToContract(Contract contract, Player player) {
        contract.setContractPlayer(player);
        contractRepo.saveAndFlush(contract);
    }

    public void addShipToContract(Contract contract, Ship ship) {
        contract.setContractShip(ship);
        contractRepo.saveAndFlush(contract);
    }

    public void removeContract(Contract contract) {
        contractRepo.delete(contract);
    }

    public void deleteContractById(Long id) {
        contractRepo.delete(contractRepo.findById(id).get());
    }
}
