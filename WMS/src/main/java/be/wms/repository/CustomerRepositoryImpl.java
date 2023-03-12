package be.wms.repository;

import be.wms.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private static final Map<String, Customer> customerMap;

    static {

        customerMap = new HashMap<>();
        customerMap.put("100001", new Customer("100001", "John", "1/1/2000", "012530", "john@codegym.vn", "Hanoi", "Hanoi", "123456789"));
        customerMap.put("100002", new Customer("100002", "John", "1/1/2000", "012530", "john@codegym.vn", "Hanoi", "Hanoi", "123456789"));
        customerMap.put("100003", new Customer("100003", "John", "1/1/2000", "012530", "john@codegym.vn", "Hanoi", "Hanoi", "123456789"));
        customerMap.put("100004", new Customer("100004", "John", "1/1/2000", "012530", "john@codegym.vn", "Hanoi", "Hanoi", "123456789"));
        customerMap.put("100005", new Customer("100005", "John", "1/1/2000", "012530", "john@codegym.vn", "Hanoi", "Hanoi", "123456789"));

    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer findByNo(String customerNo) {
        return null;
    }

    @Override
    public void create(Customer customer) {

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }
}
