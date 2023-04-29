package erpmini.be.service;

import erpmini.be.entity.Customer;
import erpmini.be.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer findByNo(Long customerNo) {
        return repository.findById(customerNo).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void remove(Long customerNo) {
        repository.deleteById(customerNo);
    }

    @Override
    public Page<Customer> findAllWithPaging(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Customer> searchAllWithPage(String customerName, String customerAddress, Pageable pageable) {
        return repository.findAllByCustomerNameContainingOrCustomerAddressContaining(
                customerName,
                customerAddress,
                pageable);
    }

    @Override
    public Customer findByCustomerCodeContaining(String customerCode) {
        return repository.findByCustomerCodeContaining(customerCode);
    }
}
