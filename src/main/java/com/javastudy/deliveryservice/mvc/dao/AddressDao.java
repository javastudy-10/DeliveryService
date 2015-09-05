package com.javastudy.deliveryservice.mvc.dao;

import com.javastudy.deliveryservice.mvc.entity.Address;

/**
 * Created by Maxim Sambulat
 */
public interface AddressDao {
    Address findByID(Long id);

    void persist(Address entity);

    Address merge(Address address);

    void remove(Address address);
}
