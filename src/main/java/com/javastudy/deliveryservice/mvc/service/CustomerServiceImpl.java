/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javastudy.deliveryservice.mvc.service;

import com.javastudy.deliveryservice.mvc.dao.CustomerDAO;
import com.javastudy.deliveryservice.mvc.entity.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tanya
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    public void persist(Customer customer) {
        customerDAO.persist(customer);
    }

    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    public void remove(Customer customer) {
        customerDAO.remove(customer);
    }

    public Customer findByID(Long id) {
        return customerDAO.findByID(id);
    }

    public Customer merge(Customer customer) {
        return customerDAO.merge(customer);
    }

}
