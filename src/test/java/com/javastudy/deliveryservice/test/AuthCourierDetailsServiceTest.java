package com.javastudy.deliveryservice.test;

import com.javastudy.deliveryservice.domain.UserRole;
import com.javastudy.deliveryservice.mvc.dao.CourierDao;
import com.javastudy.deliveryservice.mvc.dao.OperatorDao;
import com.javastudy.deliveryservice.mvc.entity.Courier;
import com.javastudy.deliveryservice.mvc.entity.Operator;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Maxim Sambulat
 */
public class AuthCourierDetailsServiceTest {
    private static String INVALID_USER_NAME = "QWERT";

    private static UserDetailsService userDetailsService;
    private static CourierDao courierDao;

    @BeforeClass
    public static void initDao() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextTest.xml");
        userDetailsService = ctx.getBean("courierDetailsService", UserDetailsService.class);
        courierDao = ctx.getBean(CourierDao.class);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void should0() throws Exception {
        UserDetails userDetails = userDetailsService.loadUserByUsername(INVALID_USER_NAME);
        assertNull(userDetails);
    }

    @Test()
    public void should1() throws Exception {
        Courier courier = CourierTest.createCourier();
        courierDao.persist(courier);

        assertNotNull(courier.getId());

        UserDetails userDetails = userDetailsService.loadUserByUsername(CustomerTest.LOGIN);
        assertNotNull(userDetails);
        assertEquals(userDetails.getAuthorities().size(), 1);

        Set<String> namesRoles = getNameRoles(userDetails.getAuthorities());
        assertTrue(namesRoles.contains(UserRole.COURIER.getName()));
        assertFalse(namesRoles.contains(UserRole.CLIENT.getName()));
    }

    private Set<String> getNameRoles(Collection<? extends GrantedAuthority> authorities) {
        Set<String> names = new HashSet<>(authorities.size());

        for (GrantedAuthority grantedAuthority : authorities) {
            names.add(grantedAuthority.getAuthority());
        }

        return names;
    }
}
