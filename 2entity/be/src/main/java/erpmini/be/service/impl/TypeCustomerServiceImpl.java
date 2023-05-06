package erpmini.be.service.impl;

import erpmini.be.entity.TypeCustomer;
import erpmini.be.repository.TypeCustomerRepository;
import erpmini.be.service.TypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeCustomerServiceImpl implements TypeCustomerService {
    @Autowired
    private TypeCustomerRepository repository;

    @Override
    public List<TypeCustomer> findAll() {
        return (List<TypeCustomer>) repository.findAll();
    }

    @Override
    public TypeCustomer findByNo(Long typeNo) {
        return repository.findById(typeNo).orElse(null);
    }

    @Override
    public void save(TypeCustomer typeCustomer) {
        repository.save(typeCustomer);
    }

    @Override
    public void remove(Long typeNo) {
        repository.deleteById(typeNo);
    }
}
