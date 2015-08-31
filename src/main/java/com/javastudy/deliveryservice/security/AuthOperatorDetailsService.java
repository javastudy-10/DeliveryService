package com.javastudy.deliveryservice.security;

import com.javastudy.deliveryservice.domain.UserRole;
import com.javastudy.deliveryservice.mvc.dao.OperatorDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created by Maxim Sambulat
 */
public class AuthOperatorDetailsService extends AuthBaseDetailsService {
    @Inject
    private OperatorDao operatorDao;

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
//        return operatorDao.findByLoginOrPhoneOrEmail(login);
    }

    @Override
    protected Set<UserRole> getUserRoles() {
        return EnumSet.of(UserRole.OPERATOR);
    }
}
