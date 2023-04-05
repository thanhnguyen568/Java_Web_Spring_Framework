package be.cms.repository;

import be.cms.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    List<Customer> findAllByCustomerNameContainingOrCustomerAddressContainingOrCustomerTelContaining(String customerName,
                                                                                                     String customerAddress,
                                                                                                     String customerTel);

    Page<Customer> findAllByCustomerNameContainingOrCustomerAddressContaining(String customerName, String customerAddress,
                                                                              Pageable pageable);

    //Check duplicate code
    Customer findByCustomerCodeContaining(String customerCode);


}
