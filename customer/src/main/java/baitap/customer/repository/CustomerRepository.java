package baitap.customer.repository;

import baitap.customer.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    void create(Customer customer);

    Customer findByNo(String customerNo);

    void update(Customer customer);

    void delete(Customer customer);

}
