package com.example.sneakershop.controller;

import com.example.sneakershop.entity.Orders;
import com.example.sneakershop.service.OrdersService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping("/create")
    public Orders createOrders(@RequestBody Orders orders) {
        return ordersService.createOrders(orders);
    }

    @GetMapping("/all")
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Orders getOrdersById(@PathVariable Long id) {
        return ordersService.getOrdersById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrders(@PathVariable Long id) {
        ordersService.deleteOrders(id);
    }
}
