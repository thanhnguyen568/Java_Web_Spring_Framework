package baitap.wmsnew.service.impl;

import baitap.wmsnew.entity.Customer;
import baitap.wmsnew.repository.CustomerRepository;
import baitap.wmsnew.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Customer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Customer> search(String search) {
        return repository.findCustomerNameOrCustomerAddress(search);
    }

}
