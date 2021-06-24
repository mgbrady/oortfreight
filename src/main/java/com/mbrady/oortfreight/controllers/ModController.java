package com.mbrady.oortfreight.controllers;

import java.util.ArrayList;
import java.util.List;

import com.mbrady.oortfreight.models.Player;
import com.mbrady.oortfreight.services.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mod")
public class ModController {
    @Autowired
    PlayerService playerService;

    @ModelAttribute("player")
    public Player playerModel() {
        return new Player();
    }

    @ModelAttribute("manifest")
    public List<Player> initManifest() {
        return new ArrayList<>();
    }

    @GetMapping("/player_management")
    public String getAllPlayers(Model model) {
        var players = playerService.getAllPlayers();
        model.addAttribute("manifest", players);
        return "/mod/player_management";
    }

    @GetMapping("/delete_player/{id}")
    public String delete_player(@PathVariable Long id) {
        playerService.removePlayer(id);
        return "redirect:/mod/player_management";
    }
}
