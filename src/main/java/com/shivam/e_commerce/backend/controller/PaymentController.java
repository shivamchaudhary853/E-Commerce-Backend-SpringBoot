package com.shivam.e_commerce.backend.controller;

import com.shivam.e_commerce.backend.entity.Payment;
import com.shivam.e_commerce.backend.service.PaymentService;
import com.shivam.e_commerce.backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/pay")
    public Payment MakePayment(@RequestBody Payment payment){
        return paymentService.MakePayement(payment);
    }
    @GetMapping("/all")
    public List<Payment> getAllPayments(){
        return paymentService.GetAllPayments();
    }
}
