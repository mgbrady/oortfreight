package com.mbrady.oortfreight.controllers;

import java.util.ArrayList;
import java.util.List;

import com.mbrady.oortfreight.models.Contract;
import com.mbrady.oortfreight.services.ContractService;
import com.mbrady.oortfreight.models.Blueprint;
import com.mbrady.oortfreight.services.BlueprintService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ContractService contractService;

    @ModelAttribute("contract")
    public Contract contractModel() {
        return new Contract();
    }

    @ModelAttribute("available_contracts")
    public List<Contract> availableContracts() {
        return new ArrayList<>();
    }

    @Autowired
    BlueprintService blueprintService;

    @ModelAttribute("blueprint")
    public Blueprint blueprintModel() {
        return new Blueprint();
    }

    @ModelAttribute("shipyard")
    public List<Blueprint> initShipyard() {
        return new ArrayList<>();
    }

    @GetMapping("/contract_management")
    public String contract_management(Model model) {
        var contracts = contractService.findAvailableContracts().get();
        model.addAttribute("available_contracts", contracts);
        return "admin/contract_management";
    }

    @GetMapping("/delete_contract/{id}")
    public String delete_contract(@PathVariable Long id) {
        contractService.deleteContractById(id);
        return "redirect:/admin/contract_management";
    }

    @PostMapping("/create_contract/")
    public String createContract(@ModelAttribute("contract") Contract contract, Model model) {
        System.out.println(contract.getContractName());
        model.addAttribute("contract", contract);
        contractService.saveContract(contract);
        return "redirect:/admin/contract_management";
    }

    @GetMapping("/shipyard_management")
    public String getAllBlueprints(Model model) {
        var blueprints = blueprintService.getAllBlueprints();
        model.addAttribute("shipyard", blueprints);
        return "admin/shipyard_management";
    }

    @GetMapping("/delete_blueprint/{id}")
    public String delete_blueprint(@PathVariable Long id) {
        blueprintService.removeBlueprint(id);
        return "redirect:/admin/shipyard_management";
    }

    @PostMapping("/create_blueprint/")
    public String createBlueprint(@ModelAttribute("blueprint") Blueprint blueprint, Model model) {
        model.addAttribute("blueprint", blueprint);
        blueprintService.saveBlueprint(blueprint);
        return "redirect:/admin/shipyard_management";
    }
}
