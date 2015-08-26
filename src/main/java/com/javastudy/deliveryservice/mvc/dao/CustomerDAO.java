/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javastudy.deliveryservice.mvc.dao;

import com.javastudy.deliveryservice.mvc.entity.Customer;
import java.util.List;

/**
 *
 * @author Tanya
 */
public interface CustomerDAO {
    public void persist(Customer customer);

    public List<Customer> findAll();

    public void remove(Customer customer);

    public Customer findByID(Long id);

    public Customer merge(Customer customer);
}

