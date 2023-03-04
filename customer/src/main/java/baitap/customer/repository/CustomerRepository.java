package baitap.customer.repository;

import baitap.customer.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    void create(Customer customer);

    Customer findById(String customerId);

    void delete(Customer customer);

    void update(Customer customer);

}
