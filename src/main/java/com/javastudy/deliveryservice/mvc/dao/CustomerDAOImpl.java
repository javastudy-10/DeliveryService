/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javastudy.deliveryservice.mvc.dao;

import com.javastudy.deliveryservice.mvc.entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tanya
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    EntityManager manager;

    public void persist(Customer customer) {
        manager.getTransaction().begin();
        manager.persist(customer);
        manager.getTransaction().commit();
    }

    public List<Customer> findAll() {
        Query query = manager.createQuery("SELECT c FROM Customer c");
        List<Customer> list = query.getResultList();
        return list;
    }

    public void remove(Customer customer) {
        manager.getTransaction().begin();
        manager.remove(manager.merge(customer));
        manager.getTransaction().commit();
    }

    public Customer findByID(Long id) {
        Customer customer = manager.find(Customer.class, id);
        return customer;
    }

    public Customer merge(Customer customer) {
        manager.getTransaction().begin();
        customer = manager.merge(customer);
        manager.getTransaction().commit();
        return customer;
    }

}
