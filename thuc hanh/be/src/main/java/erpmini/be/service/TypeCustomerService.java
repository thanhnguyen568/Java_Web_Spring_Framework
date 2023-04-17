package erpmini.be.service;

import erpmini.be.entity.TypeCustomer;

import java.util.List;

public interface TypeCustomerService {

    TypeCustomer findByNo(Long typeNo);

    void save(TypeCustomer typeCustomer);

    void remove(Long typeNo);

    List<TypeCustomer> findAll();
}
