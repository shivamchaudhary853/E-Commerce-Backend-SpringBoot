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

    private final KafkaProducerService kafkaProducerService;

    public Order placeOrder(Order order){

        Order savedOrder =
                orderRepository.save(order);

        kafkaProducerService.SendMessage(
                "Order Placed Successfully. Order Id: "
                        + savedOrder.getId()
        );

        return savedOrder;
    }
    public List<Order> GetALlOrders(){
        return orderRepository.findAll();
    }

    public Order updateStatus(
            Long id,
            String status){

        Order order =
                orderRepository.findById(id)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Order Not Found"
                                )
                        );

        order.setStatus(status);

        Order updatedOrder =
                orderRepository.save(order);

        kafkaProducerService.SendMessage(
                "Order "
                        + updatedOrder.getId()
                        + " status changed to "
                        + status
        );

        System.out.println("🔥 Kafka Event Sent");

        return updatedOrder;
    }
}
