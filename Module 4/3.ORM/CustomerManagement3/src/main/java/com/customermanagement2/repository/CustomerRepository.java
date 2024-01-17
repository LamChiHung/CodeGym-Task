package com.customermanagement2.repository;

import com.customermanagement2.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List <Customer> getAll() {
        String query = "SELECT c from Customer as c";
        TypedQuery <Customer> typedQuery = entityManager.createQuery(query, Customer.class);
        return typedQuery.getResultList();
    }

    @Override
    public Customer findById(int id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() == 0) {
            entityManager.persist(customer);
        } else {
            entityManager.merge(customer);
        }
    }

    @Override
    public void deleteById(int id) {
        Customer customer = findById(id);
        entityManager.remove(customer);
    }
}
