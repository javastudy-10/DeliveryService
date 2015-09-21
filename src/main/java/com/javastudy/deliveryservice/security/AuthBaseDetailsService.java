package com.javastudy.deliveryservice.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Maxim Sambulat
 */
public abstract class AuthBaseDetailsService implements UserDetailsService {
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        AuthInfo authentication = getAuthInfo(login);

        if(authentication == null) {
            throw new UsernameNotFoundException(String.format("The user with the Login: '%s' not found.", login));
        }

        List<GrantedAuthority> authorities = buildUserAuthority(getUserRoles());

        return buildUserForAuthentication(authentication, authorities);
    }

    protected org.springframework.security.core.userdetails.User buildUserForAuthentication(AuthInfo authInfo, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(
                authInfo.getLogin(),
                authInfo.getPassword(),
                authInfo.isEnabled(),
                true, true, true,
                authorities);
    }

    protected List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>(userRoles.size());

        for (UserRole userRole : userRoles) {
            authorities.add(new SimpleGrantedAuthority(userRole.getName()));
        }

        return new ArrayList<>(authorities);
    }

    protected abstract AuthInfo getAuthInfo(String login);

    /**
     * The roles of the Entity
     * @return set roles
     */
    protected abstract Set<UserRole> getUserRoles();
}
