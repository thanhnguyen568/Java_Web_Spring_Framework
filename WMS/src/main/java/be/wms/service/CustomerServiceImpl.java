package be.wms.service;

import be.wms.entity.Customer;
import be.wms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository repository;

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findByNo(String customerNo) {
        return repository.findByNo(customerNo);
    }

    @Override
    public void create(Customer customer) {
        repository.create(customer);
    }

    @Override
    public void update(Customer customer) {
        repository.update(customer);
    }

    @Override
    public void delete(Customer customer) {
        repository.delete(customer);
    }
}
