package com.example.bakkatest.controllers;

import com.example.bakkatest.DAO.BakkaRepository;
import com.example.bakkatest.entities.Order;
import com.example.bakkatest.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public String orders(Model model){
        Iterable<Order> orders = orderService.getOrders();
        model.addAttribute("orders", orders);
        return "orders";
    }
}
