package com.waracle.cake_manager_client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CakeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/cakes")
    public String cakes() { return "cakes"; }

}