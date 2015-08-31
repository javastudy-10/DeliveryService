package com.javastudy.deliveryservice.mvc.dao;

import com.javastudy.deliveryservice.mvc.entity.Operator;

import java.util.List;

/**
 * Created by Maxim Sambulat
 */
public interface OperatorDao {
    Operator findByLoginOrPhoneOrEmail(String login);

    Operator findById(Long id);

    List<Operator> findAll();

    void persist(Operator operator);
}
