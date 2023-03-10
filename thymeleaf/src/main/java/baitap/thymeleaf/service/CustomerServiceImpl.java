package baitap.thymeleaf.service;

import baitap.thymeleaf.model.Customer;
import baitap.thymeleaf.repository.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void create(Customer customer) {
        customerRepository.create(customer);
    }

    @Override
    public Customer findByNo(int customerNo) {
        return customerRepository.findByNo(customerNo);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.update(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }
}
