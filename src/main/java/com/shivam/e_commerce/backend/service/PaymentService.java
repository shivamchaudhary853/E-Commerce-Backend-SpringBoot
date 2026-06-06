package com.shivam.e_commerce.backend.service;

import com.shivam.e_commerce.backend.Repository.PaymentRepository;
import com.shivam.e_commerce.backend.entity.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {


    private final PaymentRepository paymentRepository;

    public Payment MakePayement(Payment payment){
        payment.setStatus("SUCCESS");
        return paymentRepository.save(payment);
    }

    public List<Payment> GetAllPayments(){
        return paymentRepository.findAll();
    }
}
