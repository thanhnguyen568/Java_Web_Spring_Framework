package baitap.thymeleaf.repository;

import baitap.thymeleaf.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    void create(Customer customer);

    Customer findByNo(int customerNo);

    void update(Customer customer);

    void delete(Customer customer);
}
