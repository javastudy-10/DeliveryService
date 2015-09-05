package com.javastudy.deliveryservice.mvc.dao;

import com.javastudy.deliveryservice.mvc.entity.Address;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by Maxim Sambulat
 */
@Component("addressDao")
@Transactional
public class AddressDaoImpl implements AddressDao {
    @PersistenceContext
    private EntityManager em;

    public AddressDaoImpl() {
    }


    public Address findByID(Long id) {
        return em.find(Address.class, id);
    }


    public void persist(Address entity) {
        em.persist(entity);
    }


    public Address merge(Address address) {
        return em.merge(address);
    }


    public void remove(Address address) {
        Address reference = em.getReference(Address.class, address.getId());
        em.remove(reference);
        address.setId(null);
    }
}
