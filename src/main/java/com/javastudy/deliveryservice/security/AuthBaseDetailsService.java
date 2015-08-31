package com.javastudy.deliveryservice.security;

import com.javastudy.deliveryservice.domain.UserRole;
import com.javastudy.deliveryservice.mvc.entity.embeddable.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by Maxim Sambulat
 */
public abstract class AuthBaseDetailsService implements UserDetailsService {
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Authentication authentication = getUserInfo(login);

        if (authentication == null) {
            throw new UsernameNotFoundException(String.format("The user with the Login or Phone or Email: '%s' not found.", login));
        }

        List<GrantedAuthority> authorities = buildUserAuthority(getUserRoles());

        return buildUserForAuthentication(authentication, authorities);
    }

    protected org.springframework.security.core.userdetails.User buildUserForAuthentication(Authentication authentication, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(
                authentication.getLogin(),
                authentication.getPassword(),
                authentication.isEnabled(),
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

    protected abstract Authentication getUserInfo(String login);

    /**
     * The roles of the Entity
     * @return set roles
     */
    protected abstract Set<UserRole> getUserRoles();
}
