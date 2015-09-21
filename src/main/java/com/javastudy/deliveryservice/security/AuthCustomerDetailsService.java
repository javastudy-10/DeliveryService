package com.javastudy.deliveryservice.security;

import com.javastudy.deliveryservice.mvc.dao.CustomerDao;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created by Maxim Sambulat
 */
public class AuthCustomerDetailsService extends AuthBaseDetailsService {
    @Inject
    private CustomerDao customerDao;

    @Override
    @Transactional
    protected AuthInfo getAuthInfo(final String login) {
        return customerDao.findByLogin(login);
    }

    @Override
    protected Set<UserRole> getUserRoles() {
        return EnumSet.of(UserRole.CLIENT);
    }
}
