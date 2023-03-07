package baitap.customer.repository;

import baitap.customer.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private static Map<String, Customer> customerMap;

    static {
        customerMap = new HashMap<>();
        customerMap.put("KH001", new Customer("KH001", "Hai", "hai@gmail.com", "Da Nang"));
        customerMap.put("KH002", new Customer("KH002", "Lan", "lan@gmail.com", "Da Nang"));
        customerMap.put("KH003", new Customer("KH003", "Khanh", "khanh@gmail.com", "Quang Nam"));
        customerMap.put("KH004", new Customer("KH004", "Thanh", "thanh@gmail.com", "Da Nang"));
        customerMap.put("KH005", new Customer("KH005", "Hung", "hung@gmail.com", "Da Nang"));
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
    public Customer findByNo(String customerNo) {
        return customerMap.get(customerNo);
    }

    @Override
    public void delete(Customer customer) {
        if (customerMap.containsKey(customer.getCustomerNo())) {
            customerMap.remove(customer.getCustomerNo());
        }
    }

    @Override
    public void update(Customer customer) {
        if (customerMap.containsKey(customer.getCustomerNo())) {
            customerMap.put(customer.getCustomerNo(), customer);
        }
    }
}
