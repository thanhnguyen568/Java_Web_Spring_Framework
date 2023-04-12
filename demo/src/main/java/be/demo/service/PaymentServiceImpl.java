package be.demo.service;

import be.demo.entity.Payment;
import be.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentRepository repository;
    @Override
    public List<Payment> findAll() {
        return (List<Payment>) repository.findAll();
    }

    @Override
    public Payment findByNo(Long paymentNo) {
        return repository.findById(paymentNo).orElse(null);
    }

    @Override
    public void save(Payment payment) {

    }

    @Override
    public void remove(Long paymentNo) {

    }
}
