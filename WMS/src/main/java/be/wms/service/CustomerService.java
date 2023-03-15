package be.wms.service;

import be.wms.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findByNo(String customerNo);

    void create(Customer customer);

    void update(Customer customer);

    void delete(Customer customer);
}
