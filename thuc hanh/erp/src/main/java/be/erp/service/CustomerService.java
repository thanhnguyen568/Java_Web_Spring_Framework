package be.erp.service;

import be.erp.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findByNo(long customerNo);

    void save(Customer customer);

    void update(Customer customer);

    void remove(long customerNo);

    Page<Customer> findAllWithPaging(Pageable pageable);

    List<Customer> search(String search);

}
