package com.javastudy.deliveryservice.test;

import com.javastudy.deliveryservice.mvc.dao.CustomerDao;
import com.javastudy.deliveryservice.mvc.entity.Address;
import com.javastudy.deliveryservice.mvc.entity.Customer;
import com.javastudy.deliveryservice.mvc.entity.embeddable.UserInfo;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Maxim Sambulat
 */
public class CustomerTest {
    public static final String LOGIN = "admin";
    public static final String PASSWORD = "root";
    public static final String FIRST_NAME = "Jon";
    public static final String LAST_NAME = "Smith";
    public static final String PHONE = "095-75-78-753";
    public static final String EMAIL = "qwe@qwe.qwe";

    static CustomerDao customerDao;
    private static Long id = 0L;

    public static Customer createCustomer() {
        Customer customer = new Customer();
        customer.setLogin(LOGIN);
        customer.setPassword(PASSWORD);
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);
        customer.setPhone(PHONE);
        customer.setEmail(EMAIL);

        customer.setAddress(AddressTest.createAddress());
        return customer;
    }

    public static void customerEquals(Customer customer) {
        assertNotNull(customer);
        assertEquals(LOGIN, customer.getLogin());
        assertEquals(PASSWORD, customer.getPassword());
        assertEquals(FIRST_NAME, customer.getFirstName());
        assertEquals(LAST_NAME, customer.getLastName());
        assertEquals(PHONE, customer.getPhone());
        assertEquals(EMAIL, customer.getEmail());
    }

    @BeforeClass
    public static void initDao() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextTest.xml");
        customerDao = ctx.getBean(CustomerDao.class);
    }

    @Test
    public void shouldNotFindCustomer() throws Exception {
        Customer customer = customerDao.findById(100L);
        assertNull(customer);
    }

    @Test
    public void should0() throws Exception {
        List<Customer> list = customerDao.findAll();
        assertNotNull(list);
        assertEquals(0, list.size());
    }

    @Test
    public void should1() throws Exception { //shouldPersistenceCustomer
        Customer customer = createCustomer();
        Address address = AddressTest.createAddress();
        customer.setAddress(address);

        customerDao.persist(customer);

        assertNotNull(customer.getId());
        id = customer.getId();
    }

    @Test
    public void should2() throws Exception { //shouldFindByIdCustomer
        Customer customer = customerDao.findById(id);
        customerEquals(customer);
    }

    @Test
    public void should3() throws Exception { //shouldFindByIdWithAddressCustomer
        Customer customer = customerDao.findByIdWithAddress(id);
        customerEquals(customer);
        AddressTest.addressEquals(customer.getAddress());
    }

    @Test
    public void should4() throws Exception {
        Customer customer = customerDao.findByLoginOrPhoneOrEmail(CustomerTest.LOGIN);

        CustomerTest.customerEquals(customer);
    }

    @Test
    public void should5() throws Exception {
        Customer customerInfoLogin = customerDao.findByLoginOrPhoneOrEmail(CustomerTest.LOGIN);
        assertNotNull(customerInfoLogin);

        Customer customerInfoPhone = customerDao.findByLoginOrPhoneOrEmail(CustomerTest.PHONE);
        assertNotNull(customerInfoPhone);

        Customer customerInfoEmail = customerDao.findByLoginOrPhoneOrEmail(CustomerTest.EMAIL);
        assertNotNull(customerInfoEmail);

        assertEquals(customerInfoLogin.getId(), customerInfoPhone.getId());
        assertEquals(customerInfoLogin.getId(), customerInfoEmail.getId());
    }
}
