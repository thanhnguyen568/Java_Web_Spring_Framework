package baitap.wmsnew.repository;

import baitap.wmsnew.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    List<Customer> findByCustomerNameContains(String name);

}
