package be.demo.service;

import be.demo.entity.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> findAll();

    Payment findByNo(Long paymentNo);

    void save(Payment payment);

    void remove(Long paymentNo);
}
