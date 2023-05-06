package be.cms.service;

import be.cms.entity.Customer;
import be.cms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository repository;

    @Override
    public Customer findByNo(Long customerNo) {
        return repository.findById(customerNo).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void remove(Long customerNo) {
        repository.deleteById(customerNo);
    }

    @Override
    public List<Customer> findAll() {
        Iterable<Customer> iterable = repository.findAll();
        List<Customer> list = new ArrayList<>();
        for (Customer c : iterable) {
            list.add(c);
        }
        return list;
    }

    @Override
    public Page<Customer> findAllWithPaging(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Customer> searchAll(String customerName, String customerAddress, String customerTel) {
        return repository.findAllByCustomerNameContainingOrCustomerAddressContainingOrCustomerTelContaining(customerName,
                customerAddress, customerTel);
    }

    @Override
    public Page<Customer> searchAllWithPage(String customerName, String customerAddress, Pageable pageable) {
        return repository.findAllByCustomerNameContainingOrCustomerAddressContaining(customerName, customerAddress, pageable);
    }

    @Override
    public Customer findByCustomerCodeContaining(String customerCode) {
        return repository.findByCustomerCodeContaining(customerCode);
    }

}
