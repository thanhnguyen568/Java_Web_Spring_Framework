package erpmini.be.repository;

import erpmini.be.entity.TypeCustomer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCustomerRepository extends PagingAndSortingRepository<TypeCustomer, Long> {
}
