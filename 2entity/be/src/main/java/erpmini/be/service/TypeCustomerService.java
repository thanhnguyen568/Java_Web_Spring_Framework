package erpmini.be.service;

import erpmini.be.entity.TypeCustomer;

import java.util.List;

public interface TypeCustomerService {
    List<TypeCustomer> findAll();

    TypeCustomer findByNo(Long typeNo);

    void save(TypeCustomer typeCustomer);

    void remove(Long typeNo);

}
