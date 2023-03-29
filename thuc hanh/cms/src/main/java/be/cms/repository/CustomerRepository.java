package be.cms.repository;

import be.cms.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    List<Customer> findAllByCustomerNameContainingOrCustomerAddressContainingOrCustomerTelContaining(String customerName,String customerAddress,String customerTel);

    void deleteAllByCustomerNoIn(String[] no);
}
