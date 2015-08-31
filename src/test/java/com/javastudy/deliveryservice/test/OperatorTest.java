package com.javastudy.deliveryservice.test;

import com.javastudy.deliveryservice.mvc.dao.OperatorDao;
import com.javastudy.deliveryservice.mvc.entity.Operator;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Maxim Sambulat
 */
public class OperatorTest {
    public static final String LOGIN = "admin";
    public static final String PASSWORD = "root";
    public static final String FIRST_NAME = "Jon";
    public static final String LAST_NAME = "Smith";
    public static final String PHONE = "095-75-78-753";
    public static final String EMAIL = "qwe@qwe.qwe";

    static OperatorDao operatorDao;
    private static Long id = 0L;

    public static Operator createOperator() {
        Operator operator = new Operator();
        operator.setLogin(LOGIN);
        operator.setPassword(PASSWORD);
        operator.setFirstName(FIRST_NAME);
        operator.setLastName(LAST_NAME);
        operator.setPhone(PHONE);
        operator.setEmail(EMAIL);

        return operator;
    }

    public static void operatorEquals(Operator operator) {
        assertNotNull(operator);
        assertEquals(LOGIN, operator.getLogin());
        assertEquals(PASSWORD, operator.getPassword());
        assertEquals(FIRST_NAME, operator.getFirstName());
        assertEquals(LAST_NAME, operator.getLastName());
        assertEquals(PHONE, operator.getPhone());
        assertEquals(EMAIL, operator.getEmail());
    }

    @BeforeClass
    public static void initDao() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextTest.xml");
        operatorDao = ctx.getBean(OperatorDao.class);
    }

    @Test
    public void should0() throws Exception {
        Operator operator = operatorDao.findById(100L);
        assertNull(operator);
    }

    @Test
    public void should1() throws Exception {
        List<Operator> list = operatorDao.findAll();
        assertNotNull(list);
        assertEquals(0, list.size());
    }

    @Test
    public void should2() throws Exception {
        Operator operator = createOperator();
        operatorDao.persist(operator);

        assertNotNull(operator.getId());
        id = operator.getId();
    }

    @Test
    public void should3() throws Exception {
        Operator operator = operatorDao.findById(id);
        operatorEquals(operator);
    }

    @Test
    public void should4() throws Exception {
        Operator operator = operatorDao.findByLoginOrPhoneOrEmail(CustomerTest.LOGIN);
        operatorEquals(operator);
    }

    @Test
    public void should5() throws Exception {
        Operator operatorInfoLogin = operatorDao.findByLoginOrPhoneOrEmail(CustomerTest.LOGIN);
        assertNotNull(operatorInfoLogin);

        Operator operatorInfoPhone = operatorDao.findByLoginOrPhoneOrEmail(CustomerTest.PHONE);
        assertNotNull(operatorInfoPhone);

        Operator operatorInfoEmail = operatorDao.findByLoginOrPhoneOrEmail(CustomerTest.EMAIL);
        assertNotNull(operatorInfoEmail);

        assertEquals(operatorInfoLogin.getId(), operatorInfoPhone.getId());
        assertEquals(operatorInfoLogin.getId(), operatorInfoEmail.getId());
    }
}
