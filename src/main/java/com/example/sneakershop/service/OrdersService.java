package com.example.sneakershop.service;

import com.example.sneakershop.entity.Orders;
import com.example.sneakershop.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public Orders createOrders(Orders orders) {
        return ordersRepository.save(orders);
    }

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Orders getOrdersById(Long id) {
        return ordersRepository.findById(id).orElse(null);
    }

    public void deleteOrders(Long id) {
        ordersRepository.deleteById(id);
    }
}
