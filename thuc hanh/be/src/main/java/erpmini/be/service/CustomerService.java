package erpmini.be.service;

import erpmini.be.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService{
    Customer findByNo(Long customerNo);

    void save(Customer customer);

    void remove(Long customerNo);

    List<Customer> findAll();

    Page<Customer> findAllWithPaging(Pageable pageable);

    List<Customer> searchAll(String customerName, String customerAddress, String customerTel);

    Page<Customer> searchAllWithPage(String customerName, String customerAddress, Pageable pageable);

    //    Check duplicate code
    Customer findByCustomerCodeContaining(String customerCode);

}
