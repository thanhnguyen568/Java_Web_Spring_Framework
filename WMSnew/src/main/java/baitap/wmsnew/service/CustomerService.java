package baitap.wmsnew.service;

import baitap.wmsnew.entity.Customer;
import baitap.wmsnew.entity.CustomerType;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findByNo(long customerNo);

    void save(Customer customer);

    void update(Customer customer);

    void remove(long customerNo);

    List<Customer> findAllByCustomerType(CustomerType customerType);

}
