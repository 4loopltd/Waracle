package com.waracle.cake_manager_client.controller;

import com.waracle.cake_manager_client.model.CakeDTO;
import com.waracle.cake_manager_client.service.CakeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@SuppressWarnings("SameReturnValue")
@Controller
public class CakeController {

    final CakeService cakeService;

    public CakeController(CakeService cakeService) {
        this.cakeService = cakeService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/cakes")
    public String cakes(Model model) {
        List<CakeDTO> cakes = cakeService.findAll();
        model.addAttribute("cakes", cakes);
        model.addAttribute("cake", new CakeDTO());
        return "cakes";
    }

    @PostMapping("/cake-submit")
    public String cakeSubmit(@ModelAttribute CakeDTO cake) {
        cakeService.create(cake);
        return "redirect:/cakes";
    }

    @ExceptionHandler
    public String handleError(Model model, Exception ex) {
        model.addAttribute("error", ex.getMessage());
        return "error";
    }

}