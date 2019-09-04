package com.example.bakkatest.controllers;

import com.example.bakkatest.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/create-order")
    public String createOrder(Model model){
        model.addAttribute("Products",orderService.getProducts());
        return "create-order";
    }
}
