package com.mbrady.oortfreight.services;

import java.util.List;
import java.util.Optional;

import com.mbrady.oortfreight.dao.IContractRepo;
import com.mbrady.oortfreight.models.Contract;
import com.mbrady.oortfreight.models.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContractService {
    @Autowired
    IContractRepo contractRepo;

    public Optional<List<Contract>> findByPlayer(Player player) {
        return contractRepo.findByContractPlayer(player);
    }

    public void removeContract(Contract contract) {
        contractRepo.delete(contract);
    }
}
