package com.mbrady.oortfreight.controllers;

import java.util.ArrayList;
import java.util.List;

import com.mbrady.oortfreight.models.Contract;
import com.mbrady.oortfreight.models.Player;
import com.mbrady.oortfreight.models.Ship;
import com.mbrady.oortfreight.services.ContractService;
import com.mbrady.oortfreight.services.PlayerService;
import com.mbrady.oortfreight.services.ShipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    PlayerService playerService;

    @Autowired
    ContractService contractService;

    @Autowired
    ShipService shipService;

    @ModelAttribute("player")
    public Player playerModel() {
        return new Player("bingo");
    }

    @ModelAttribute("contract")
    public Contract contractModel() {
        return new Contract();
    }

    @ModelAttribute("ship")
    public Ship shipModel() {
        return new Ship();
    }

    @ModelAttribute("players")
    public List<Player> playerListModel() {
        return new ArrayList<>();
    }


    @GetMapping("/getallplayers")
    public String getAllPlayers(Model model) {
        //var players = playerService.getAllPlayers();
        //players.forEach(player -> System.out.println(player.getPlayerName()));
        //model.addAttribute("players", players);
        model.addAttribute("players", playerService.getAllPlayers());
        return "players";
    }

    @GetMapping("/error")
    public String errorView() {
        return "error";
    }
}
