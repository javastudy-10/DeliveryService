package com.javastudy.deliveryservice.mvc.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Maxim Sambulat
 */
@Service("addressService")
@Repository
@Transactional
public class AddressServiceImpl implements AddressService {
//
//    public List<Address> findAll() {
//        return em.createNamedQuery("Address.findAll").getResultList();
//    }
//
//    public Address save(Address address) {
//        if (address.getId() == null) {
//            em.persist(address);
//        } else {
//            em.merge(address);
//        }
//
//        return address;
//    }
//
//    public void delete(Address address) {
//        Address mergedAddress = em.merge(address);
//        em.remove(mergedAddress);
//    }
}
