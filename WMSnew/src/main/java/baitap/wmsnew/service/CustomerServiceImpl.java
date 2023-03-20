package baitap.wmsnew.service;

import baitap.wmsnew.entity.Customer;
import baitap.wmsnew.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository repository;


    @Override
    public List<Customer> findAll() {
        Iterable<Customer> iterable = repository.findAll();
        List<Customer> customerList = new ArrayList<>();
        for (Customer c : iterable) {
            customerList.add(c);
        }
        return customerList;
    }

    @Override
    public Customer findByNo(long customerNo) {
        return (Customer) repository.findById(customerNo).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void remove(long customerNo) {
        repository.deleteById(customerNo);
    }

    @Override
    public List<Customer> findByName(String customerName) {
        return repository.findByCustomerNameContains(customerName);
    }
}
