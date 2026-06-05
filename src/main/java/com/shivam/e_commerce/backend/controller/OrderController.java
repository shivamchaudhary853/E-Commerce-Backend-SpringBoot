package com.shivam.e_commerce.backend.controller;

import com.shivam.e_commerce.backend.entity.Order;
import com.shivam.e_commerce.backend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/place")
    public Order PlaceOrder(@RequestBody Order order){
        return orderService.PlaceOrder(order);
    }
    @GetMapping("/all")
    public List<Order> GetALlOrders(){
        return orderService.GetALlOrders();
    }
}
