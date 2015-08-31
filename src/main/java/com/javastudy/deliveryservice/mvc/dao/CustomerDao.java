package com.javastudy.deliveryservice.mvc.dao;

import com.javastudy.deliveryservice.mvc.entity.Customer;

import java.util.List;

/**
 * Created by Maxim Sambulat
 */
public interface CustomerDao {
    Customer findByLoginOrPhoneOrEmail(String login);

    Customer findById(Long id);

    Customer findByIdWithAddress(Long id);

    List<Customer> findAll();

    void persist(Customer customer);
}
