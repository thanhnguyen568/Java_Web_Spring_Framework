package baitap.wmsnew.service.impl;

import baitap.wmsnew.entity.Customer;
import baitap.wmsnew.entity.CustomerType;
import baitap.wmsnew.repository.CustomerRepository;
import baitap.wmsnew.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

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
        return repository.findById(customerNo).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public void remove(long customerNo) {
        repository.deleteById(customerNo);
    }

    @Override
    public List<Customer> findAllByCustomerType(CustomerType customerType) {
        return repository.findAllByCustomerType(customerType);
    }


}
