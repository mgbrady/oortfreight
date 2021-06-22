package com.mbrady.oortfreight.controllers;

import com.mbrady.oortfreight.models.Contract;
import com.mbrady.oortfreight.models.Player;
import com.mbrady.oortfreight.models.Ship;
import com.mbrady.oortfreight.services.ContractService;
import com.mbrady.oortfreight.services.PlayerService;
import com.mbrady.oortfreight.services.ShipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("player")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @Autowired
    ContractService contractService;

    @Autowired
    ShipService shipService;

    @ModelAttribute("player")
    public Player initPlayer() {
        return new Player();
    }

    @ModelAttribute("contract")
    public Contract initContract() {
        return new Contract();
    }

    @ModelAttribute("ship")
    public Ship initShip() {
        return new Ship();
    }
}
