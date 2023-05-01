package erpmini.be.repository;

import erpmini.be.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Page<Customer> findAllByCustomerNameContainingOrCustomerAddressContaining(
            String customerName,
            String customerAddress,
            Pageable pageable);

    @Query(nativeQuery = true, value = "Select * from customer where customer_name like %:customerName% " +
            "or customer_address like %:customerAddress%")
    Page<Customer> findByNative(@Param("customerName") String customerName,
                                @Param("customerAddress") String customerAddress,
                                Pageable pageable);

    @Query("Select c from Customer c where c.customerName like %:customerName% " +
            "or c.customerAddress like %:customerAddress%")
    Page<Customer> findByHQL(@Param("customerName") String customerName,
                             @Param("customerAddress") String customerAddress,
                             Pageable pageable);

    //Check duplicate code
    Customer findByCustomerCodeContaining(String customerCode);
}
