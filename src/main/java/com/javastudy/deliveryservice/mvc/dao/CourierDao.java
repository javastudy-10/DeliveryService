package com.javastudy.deliveryservice.mvc.dao;

import com.javastudy.deliveryservice.mvc.entity.Courier;

import java.util.List;

/**
 * Created by Maxim Sambulat
 */
public interface CourierDao {
    Courier findByLoginOrPhoneOrEmail(String login);

    Courier findById(Long id);

    List<Courier> findAll();

    void persist(Courier courier);
}
