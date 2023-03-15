package be.wms.repository;

import be.wms.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("select s from Customer s").getResultList();
    }

    @Override
    public Customer findByNo(String customerNo) {
        return entityManager.find(Customer.class, customerNo);
    }

    @Override
    public void create(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public void update(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public void delete(Customer customer) {
        entityManager.remove(entityManager.merge(customer));
    }

}
