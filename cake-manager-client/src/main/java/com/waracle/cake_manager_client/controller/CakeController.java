package com.waracle.cake_manager_client.controller;

import com.waracle.cake_manager_client.model.CakeDTO;
import com.waracle.cake_manager_client.service.CakeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CakeController {

    final CakeService cakeService;

    public CakeController(CakeService cakeService) {
        this.cakeService = cakeService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/cakes")
    public String cakes(Model model) {

        List<CakeDTO> cakes = cakeService.findAll();
        model.addAttribute("cakes", cakes);

        return "cakes";
    }

    @ExceptionHandler
    public String handleError(Model model, Exception ex) {
        model.addAttribute("error", ex.getMessage());
        return "error";
    }

}