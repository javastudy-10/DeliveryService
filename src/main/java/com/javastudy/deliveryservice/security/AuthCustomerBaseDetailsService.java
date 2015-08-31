package com.javastudy.deliveryservice.security;

import com.javastudy.deliveryservice.domain.UserRole;
import com.javastudy.deliveryservice.mvc.dao.CustomerDao;
import com.javastudy.deliveryservice.mvc.entity.Customer;
import com.javastudy.deliveryservice.mvc.entity.embeddable.UserInfo;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created by Maxim Sambulat
 */
public class AuthCustomerBaseDetailsService extends AuthBaseDetailsService {
    @Inject
    private CustomerDao customerDao;

    @Override
    @Transactional
    protected Authentication getUserInfo(final String login) {
        return new Authentication() {

            @Override
            public String getLogin() {
                return login;
            }

            @Override
            public String getPassword() {
                return "12345678";
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
//        return customerDao.findByLoginOrPhoneOrEmail(login);
    }

    @Override
    protected Set<UserRole> getUserRoles() {
        return EnumSet.of(UserRole.CLIENT);
    }
}
