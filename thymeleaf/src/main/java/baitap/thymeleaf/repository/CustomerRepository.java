package baitap.thymeleaf.repository;

import baitap.thymeleaf.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findByNo(int customerNo);

    void create(Customer customer);

    void update(Customer customer);

    void delete(Customer customer);
}
