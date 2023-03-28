package be.cms.service;

import be.cms.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService{
    List<Customer> findAll();

    Customer findByNo(Long customerNo);

    void save(Customer customer);

    void remove(Long customerNo);
    Page<Customer> findAllWithPaging(Pageable pageable);

    List<Customer> search(String search);
}
