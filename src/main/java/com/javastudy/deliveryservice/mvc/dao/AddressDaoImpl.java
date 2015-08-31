package com.javastudy.deliveryservice.mvc.dao;

import com.javastudy.deliveryservice.mvc.entity.Address;
import com.javastudy.deliveryservice.mvc.entity.Customer;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxim Sambulat
 */
@Component("addressDao")
public class AddressDaoImpl implements AddressDao {
    @PersistenceContext
    EntityManager em;

    public AddressDaoImpl() {
    }

    @Override
    public List<Address> getUsedAddress(Customer customer) {
        return new ArrayList<Address>();
    }

    @Override
    @Transactional
    public Address findByID(Long id) {
        return em.find(Address.class, id);
    }

    @Override
    @Transactional
    public void persist(Address entity) {
        em.persist(entity);
    }
}
