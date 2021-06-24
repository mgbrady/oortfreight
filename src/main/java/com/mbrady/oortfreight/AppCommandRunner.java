package com.mbrady.oortfreight;

import com.mbrady.oortfreight.dao.IContractRepo;
import com.mbrady.oortfreight.dao.IPlayerRepo;
import com.mbrady.oortfreight.dao.IShipRepo;
import com.mbrady.oortfreight.models.Contract;
import com.mbrady.oortfreight.models.Player;
import com.mbrady.oortfreight.models.Ship;
import com.mbrady.oortfreight.services.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AppCommandRunner implements CommandLineRunner {
    @Autowired
    IPlayerRepo playerRepo;
    @Autowired
    IContractRepo contractRepo;
    @Autowired
    IShipRepo shipRepo;

    @Autowired
    PlayerService playerService;

    public void run(String... args) {
        initDatabase();
        var contract = contractRepo.findById(1L).get();
        var player = playerRepo.findById(1L).get();

        contract.setContractPlayer(player);
        contractRepo.save(contract);
    }

    void initPlayers(String... args) {
        for (var p : args) {
            playerRepo.save(new Player(p));
        }
    }

    void initContracts(String... args) {
        for (var c : args) {
            contractRepo.save(new Contract(c));
        }
    }

    void initShips(String... args) {
        for (var s : args) {
            shipRepo.save(new Ship(s));
        }
    }

    void initDatabase() {
        initPlayers("mbrady", "tywin", "jon", "danny", "ned");
        initContracts("alpha", "bravo", "charlie", "delta", "echo", "gamma", "hotel", "india", "juliet", "kilo", "lima", "mike");
        initShips("gallatin", "jefferson", "madison", "clearwater", "clark fork", "missouri", "bighorn");
    }
}