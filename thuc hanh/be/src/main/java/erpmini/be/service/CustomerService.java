package erpmini.be.service;

import erpmini.be.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Customer findByNo(Long customerNo);

    void save(Customer customer);

    void remove(Long customerNo);

    Page<Customer> searchAll(String customerName, String customerAddress, Pageable pageable);

    //    Check duplicate code
    Customer findByCustomerCodeContaining(String customerCode);

    //    List<Customer> findAll();

    //    List<Customer> searchAll(String customerName, String customerAddress, String customerTel);
}
