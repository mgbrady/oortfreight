package com.mbrady.oortfreight.controllers;

import java.util.ArrayList;
import java.util.List;

import com.mbrady.oortfreight.models.Blueprint;
import com.mbrady.oortfreight.models.Contract;
import com.mbrady.oortfreight.models.Player;
import com.mbrady.oortfreight.models.Ship;
import com.mbrady.oortfreight.services.BlueprintService;
import com.mbrady.oortfreight.services.ContractService;
import com.mbrady.oortfreight.services.PlayerService;
import com.mbrady.oortfreight.services.ShipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @Autowired
    ContractService contractService;

    @Autowired
    ShipService shipService;

    @Autowired
    BlueprintService blueprintService;

    @ModelAttribute("player")
    public Player playerModel() {
        return new Player();
    }

    @ModelAttribute("ship")
    public Ship shipModel() {
        return new Ship();
    }

    @ModelAttribute("ships")
    public List<Ship> shipList() {
        return new ArrayList<>();
    }

    @ModelAttribute("blueprints")
    public List<Blueprint> blueprintModel() {
        return new ArrayList<>();
    }

    @ModelAttribute("contracts")
    public List<Contract> contractList() {
        return new ArrayList<>();
    }

    @GetMapping("/overview/{id}")
    public String playerView(@PathVariable("id") Long id, Model model) {
        var player = playerService.getPlayerById(id);
        model.addAttribute("player", player);

        var contracts = contractService.findByPlayer(player).get();
        model.addAttribute("contracts", contracts);

        var ships = shipService.getShipsByOwner(player);
        model.addAttribute("ships", ships);

        return "/player/overview";
    }

    @GetMapping("/shipstore")
    public String shipStore(Model model) {
        var ships = blueprintService.getAllBlueprints();
        model.addAttribute("blueprints", ships);
        return "/player/shipstore";
    }

    @PostMapping("/shipstore/buyship/")
    public String buyShip(@ModelAttribute("ship") Ship ship, Model model) {
        model.addAttribute("ship", ship);
        return "redirect:/player/shipstore";
    }

    /*
    @PostMapping("/create_blueprint/")
    public String createBlueprint(@ModelAttribute("blueprint") Blueprint blueprint, Model model) {
        model.addAttribute("blueprint", blueprint);
        blueprintService.saveBlueprint(blueprint);
        return "redirect:/admin/shipyard_management";
    }
    */
}
