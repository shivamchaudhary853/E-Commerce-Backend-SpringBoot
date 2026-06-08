package com.shivam.e_commerce.backend.service;

import com.shivam.e_commerce.backend.Repository.OrderRepository;
import com.shivam.e_commerce.backend.entity.Order;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;


    public Order placeOrder(Order order){

        Order savedOrder =
                orderRepository.save(order);

        KafkaProducerService.SendMessage(
                "Order Placed Successfully. Order Id: "
                        + savedOrder.getId()
        );

        return savedOrder;
    }
    public List<Order> GetALlOrders(){
        return orderRepository.findAll();
    }
}
