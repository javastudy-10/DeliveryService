package com.javastudy.deliveryservice.mvc.dao;

import com.javastudy.deliveryservice.mvc.entity.Operator;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Maxim Sambulat
 */
@Component("operatorDao")
@Transactional
public class OperatorDaoImpl implements OperatorDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public Operator findByLoginOrPhoneOrEmail(String login) {
        try {
            return (Operator) em.createNamedQuery("Operator.findByLoginOrPhoneOrEmail").setParameter("login", login).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Operator findById(Long id) {
        return em.find(Operator.class, id);
    }

    @Override
    public List<Operator> findAll() {
        return em.createNamedQuery("Operator.findAll").getResultList();
    }

    @Override
    public void persist(Operator operator) {
        em.persist(operator);
    }
}
