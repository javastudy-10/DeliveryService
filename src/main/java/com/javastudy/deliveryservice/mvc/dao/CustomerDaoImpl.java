package com.javastudy.deliveryservice.mvc.dao;

import com.javastudy.deliveryservice.mvc.entity.Customer;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Maxim Sambulat
 */
@Component("customerDao")
@Transactional
public class CustomerDaoImpl implements CustomerDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Customer findByLogin(String login) {
//        try {
        return (Customer) em.createNamedQuery("Customer.findByLogin").setParameter("login", login).getSingleResult();
//        } catch (NoResultException e) {
//            return null;
//        }
    }

    @Override
    public Customer findById(Long id) {
        return em.find(Customer.class, id);
    }

    @Override
    public Customer findByIdWithAddress(Long id) {
        return (Customer) em.createNamedQuery("Customer.findByIdWithDetails").setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Customer> findAll() {
        return em.createNamedQuery("Customer.findAllWithDetails").getResultList();
    }

    @Override
    public void persist(Customer customer) {
        em.persist(customer);
    }

    @Override
    public Customer merge(Customer customer) {
        return em.merge(customer);
    }

    @Override
    public void remove(Customer customer) {
        Customer reference = em.getReference(Customer.class, customer.getId());
        em.remove(reference);
        customer.setId(null);
    }
}
