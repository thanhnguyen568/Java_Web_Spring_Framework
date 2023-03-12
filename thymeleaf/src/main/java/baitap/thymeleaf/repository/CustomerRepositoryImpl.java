package baitap.thymeleaf.repository;

import baitap.thymeleaf.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    private static final Map<Integer, Customer> customerMap;

    static {

        customerMap = new HashMap<>();
        customerMap.put(1, new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customerMap.put(2, new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
        customerMap.put(3, new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        customerMap.put(4, new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        customerMap.put(5, new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customerMap.put(6, new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void create(Customer customer) {
        if (!customerMap.containsKey(customer.getCustomerNo())) {
            customerMap.put(customer.getCustomerNo(), customer);
        }
    }

    @Override
    public Customer findByNo(int customerNo) {
        return customerMap.get(customerNo);
    }

    @Override
    public void update(Customer customer) {
        if (customerMap.containsKey(customer.getCustomerNo())) {
            customerMap.put(customer.getCustomerNo(), customer);
        }
    }

    @Override
    public void delete(Customer customer) {
        if (customerMap.containsKey(customer.getCustomerNo())) {
            customerMap.remove(customer.getCustomerNo());
        }
    }

}
