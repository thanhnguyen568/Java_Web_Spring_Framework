package baitap.wmsnew.service;

import baitap.wmsnew.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<Customer> findAll();

    Customer findByNo(long customerNo);

    void save(Customer customer);

    void update(Customer customer);

    void remove(long customerNo);

    List<Customer> findByName(String customerName);

}
