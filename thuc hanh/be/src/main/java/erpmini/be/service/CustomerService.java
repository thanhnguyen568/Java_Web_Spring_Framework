package erpmini.be.service;

import erpmini.be.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Customer findByNo(Long customerNo);

    void save(Customer customer);

    void remove(Long customerNo);

    Page<Customer> findAllWithPaging(Pageable pageable);

    Page<Customer> searchAllWithPage(String customerName, String customerAddress, Pageable pageable);

    //    Check duplicate code
    Customer findByCustomerCodeContaining(String customerCode);

    //    List<Customer> findAll();

    //    List<Customer> searchAll(String customerName, String customerAddress, String customerTel);
}
