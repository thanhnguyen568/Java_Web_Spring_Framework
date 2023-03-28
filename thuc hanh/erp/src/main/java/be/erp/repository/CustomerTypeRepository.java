package be.erp.repository;

import be.erp.entity.CustomerType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypeRepository extends PagingAndSortingRepository<CustomerType, Long> {
}
