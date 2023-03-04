package baitap.customer.service;

import baitap.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void create(Customer customer);

    Customer findById(String customerId);

    void delete(Customer customer);

    void update(Customer customer);
}
