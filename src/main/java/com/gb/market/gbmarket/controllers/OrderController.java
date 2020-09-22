package com.gb.market.gbmarket.controllers;


import com.gb.market.gbmarket.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;

    @GetMapping
    public String firstRequest(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "orders";
    }
}
