package baitap.wmsnew.repository;

import baitap.wmsnew.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    @Query(nativeQuery = true, value = "Select * from Customer where customerName like :customerName or customerAddress like :customerAddress")
    List<Customer> findCustomerNameOrCustomerAddress(@Param("customerName") String customerName, @Param("customerAddress") String customerAddress);

    @Query("Select c from Customer c where c.customerName > :customerName or c.customerAddress like :customerAddress")
    List<Customer> findNameOrAddress(String customerName,String customerAddress);


    @Query(nativeQuery = true, value = "Select * from Customer where customerName like :search or customerAddress like :search")
    List<Customer> findCustomerNameOrCustomerAddress(@Param("search") String search);
}
