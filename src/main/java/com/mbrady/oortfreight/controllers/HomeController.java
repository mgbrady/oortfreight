package com.mbrady.oortfreight.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    public String index() {
        return "block/block.html";
    }
}
