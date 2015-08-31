package com.javastudy.deliveryservice.mvc.dao;

import com.javastudy.deliveryservice.mvc.entity.Courier;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Maxim Sambulat
 */
@Component("courierDao")
@Transactional
public class CourierDaoImpl implements CourierDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public Courier findByLoginOrPhoneOrEmail(String login) {
        try {
            return (Courier) em.createNamedQuery("Courier.findByLoginOrPhoneOrEmail").setParameter("login", login).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Courier findById(Long id) {
        return em.find(Courier.class, id);
    }

    @Override
    public List<Courier> findAll() {
        return em.createNamedQuery("Courier.findAll").getResultList();
    }

    @Override
    public void persist(Courier courier) {
        em.persist(courier);
    }
}
