package com.javastady.deliveryservice.test;

import com.javastudy.deliveryservice.mvc.dao.CustomerDao;
import com.javastudy.deliveryservice.mvc.entity.Customer;
import com.javastudy.deliveryservice.security.UserRole;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Maxim Sambulat
 */
public class AuthCustomerDetailsServiceTest {
    private static String INVALID_USER_NAME = "QWERT";

    private static UserDetailsService userDetailsService;
    private static CustomerDao customerDao;

    @BeforeClass
    public static void initDao() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextTest.xml");
        userDetailsService = ctx.getBean("customerDetailsService", UserDetailsService.class);
        customerDao = ctx.getBean(CustomerDao.class);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void should0() throws Exception {
        UserDetails userDetails = userDetailsService.loadUserByUsername(INVALID_USER_NAME);
    }

    @Test()
    public void should1() throws Exception {
        Customer customer = CustomerTest.createCustomer();
        customerDao.persist(customer);

        assertNotNull(customer.getId());

        UserDetails userDetails = userDetailsService.loadUserByUsername(CustomerTest.LOGIN);
        assertNotNull(userDetails);
        assertEquals(userDetails.getAuthorities().size(), 1);

        Set<String> namesRoles = getNameRoles(userDetails.getAuthorities());
        assertTrue(namesRoles.contains(UserRole.CLIENT.getName()));
        assertFalse(namesRoles.contains(UserRole.OPERATOR.getName()));

    }

    private Set<String> getNameRoles(Collection<? extends GrantedAuthority> authorities) {
        Set<String> names = new HashSet<String>(authorities.size());

        for (GrantedAuthority grantedAuthority : authorities) {
            names.add(grantedAuthority.getAuthority());
        }

        return names;
    }
}
