package com.javastudy.deliveryservice.mvc.dao;

import com.javastudy.deliveryservice.mvc.entity.Address;
import com.javastudy.deliveryservice.mvc.entity.Customer;

import java.util.List;

/**
 * Created by Maxim Sambulat
 */
public interface AddressDao {
    List<Address> getUsedAddress(Customer customer);

    Address findByID(Long id);

    void persist(Address entity);
}
