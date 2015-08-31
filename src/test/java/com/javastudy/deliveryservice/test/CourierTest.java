package com.javastudy.deliveryservice.test;

import com.javastudy.deliveryservice.mvc.dao.CourierDao;
import com.javastudy.deliveryservice.mvc.entity.Courier;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Maxim Sambulat
 */
public class CourierTest {
    public static final String LOGIN = "admin";
    public static final String PASSWORD = "root";
    public static final String FIRST_NAME = "Jon";
    public static final String LAST_NAME = "Smith";
    public static final String PHONE = "095-75-78-753";
    public static final String EMAIL = "qwe@qwe.qwe";

    static CourierDao courierDao;
    private static Long id = 0L;

    public static Courier createCourier() {
        Courier courier = new Courier();
        courier.setLogin(LOGIN);
        courier.setPassword(PASSWORD);
        courier.setFirstName(FIRST_NAME);
        courier.setLastName(LAST_NAME);
        courier.setPhone(PHONE);
        courier.setEmail(EMAIL);

        return courier;
    }

    public static void courierEquals(Courier courier) {
        assertNotNull(courier);
        assertEquals(LOGIN, courier.getLogin());
        assertEquals(PASSWORD, courier.getPassword());
        assertEquals(FIRST_NAME, courier.getFirstName());
        assertEquals(LAST_NAME, courier.getLastName());
        assertEquals(PHONE, courier.getPhone());
        assertEquals(EMAIL, courier.getEmail());
    }

    @BeforeClass
    public static void initDao() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextTest.xml");
        courierDao = ctx.getBean(CourierDao.class);
    }

    @Test
    public void should0() throws Exception {
        Courier courier = courierDao.findById(100L);
        assertNull(courier);
    }

    @Test
    public void should1() throws Exception {
        List<Courier> list = courierDao.findAll();
        assertNotNull(list);
        assertEquals(0, list.size());
    }

    @Test
    public void should2() throws Exception {
        Courier courier = createCourier();
        courierDao.persist(courier);

        assertNotNull(courier.getId());
        id = courier.getId();
    }

    @Test
    public void should3() throws Exception {
        Courier courier = courierDao.findById(id);
        courierEquals(courier);
    }

    @Test
    public void should4() throws Exception {
        Courier courier = courierDao.findByLoginOrPhoneOrEmail(CustomerTest.LOGIN);
        courierEquals(courier);
    }

    @Test
    public void should5() throws Exception {
        Courier courierInfoLogin = courierDao.findByLoginOrPhoneOrEmail(CustomerTest.LOGIN);
        assertNotNull(courierInfoLogin);

        Courier courierInfoPhone = courierDao.findByLoginOrPhoneOrEmail(CustomerTest.PHONE);
        assertNotNull(courierInfoPhone);

        Courier courierInfoEmail = courierDao.findByLoginOrPhoneOrEmail(CustomerTest.EMAIL);
        assertNotNull(courierInfoEmail);

        assertEquals(courierInfoLogin.getId(), courierInfoPhone.getId());
        assertEquals(courierInfoLogin.getId(), courierInfoEmail.getId());
    }
}
