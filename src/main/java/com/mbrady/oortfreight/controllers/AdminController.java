package com.mbrady.oortfreight.controllers;

import java.util.ArrayList;
import java.util.List;

import com.mbrady.oortfreight.models.Contract;
import com.mbrady.oortfreight.services.ContractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ContractService contractService;

    @ModelAttribute("available_contracts")
    public List<Contract> availableContracts() {
        return new ArrayList<>();
    }

    @GetMapping("contract_management")
    public String contract_management(Model model) {
        var contracts = contractService.findAvailableContracts().get();
        model.addAttribute("available_contracts", contracts);
        return "admin/contract_management";
    }
}
