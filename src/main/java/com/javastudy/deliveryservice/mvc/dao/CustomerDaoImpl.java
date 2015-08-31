package com.javastudy.deliveryservice.mvc.dao;

import com.javastudy.deliveryservice.mvc.entity.Customer;
import com.javastudy.deliveryservice.mvc.entity.embeddable.UserInfo;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
    EntityManager em;

//    @PersistenceUnit
//    EntityManagerFactory emf;


    @Override
    public Customer findByLoginOrPhoneOrEmail(String login) {
        try {
            return (Customer) em.createNamedQuery("Customer.findByLoginOrPhoneOrEmail").setParameter("login", login).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Customer findById(Long id) {
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
        Customer customer = em.find(Customer.class, id);
//        tx.commit();
        return customer;
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
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
        em.persist(customer);
//        tx.commit();
    }


}
