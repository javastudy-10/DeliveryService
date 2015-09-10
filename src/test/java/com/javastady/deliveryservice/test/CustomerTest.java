package com.javastady.deliveryservice.test;

import com.javastudy.deliveryservice.mvc.dao.CustomerDao;
import com.javastudy.deliveryservice.mvc.entity.Address;
import com.javastudy.deliveryservice.mvc.entity.Customer;
import com.javastudy.deliveryservice.validation.Sizes;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;

import static com.javastady.deliveryservice.test.Util.amountConstraintViolation;
import static com.javastady.deliveryservice.test.Util.fillString;
import static org.junit.Assert.*;

/**
 * Created by Maxim Sambulat
 */
public class CustomerTest {
    public static final String LOGIN = "administrator";
    public static final String INVALID_LOGIN = "BAD_LOGIN";
    public static final String PASSWORD = "root";
    public static final String FIRST_NAME = "Jon";
    public static final String LAST_NAME = "Smith";
    public static final String PHONE = "095-75-78-753";
    public static final String EMAIL = "qwe@qwe.qwe";

    private static final int ANNOTATIONS_NOTNULL = 7;
    private static final int ANNOTATIONS_NOTEMPTY = 5;
    private static final int ANNOTATIONS_MIN_SIZE = 1;
    private static final int ANNOTATIONS_MAX_SIZE = 6;

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
    public void should00() throws Exception { //shouldNotFindCustomerById
        Customer customer = customerDao.findById(100L);
        assertNull(customer);
    }

    @Test
    public void should01() throws Exception { //shouldNotFindCustomerByLogin
        Customer customer = customerDao.findByLogin(INVALID_LOGIN);
        assertNull(customer);
    }

    @Test
    public void should02() throws Exception { //shouldNotFoundCustomers
        List<Customer> list = customerDao.findAll();
        assertNotNull(list);
        assertEquals(list.size(), 0);
    }

    @Test
    public void should03() throws Exception { //shouldPersistenceCustomer
        Customer customer = createCustomer();
        Address address = AddressTest.createAddress();
        customer.setAddress(address);

        customerDao.persist(customer);

        assertNotNull(customer.getId());
        id = customer.getId();
    }

    @Test
    public void should04() throws Exception {//shouldFoundAll
        List<Customer> list = customerDao.findAll();
        assertNotNull(list);
        assertEquals(list.size(), 1);
    }

    @Test
    public void should05() throws Exception { //shouldFindByIdCustomer
        Customer customer = customerDao.findById(id);
        customerEquals(customer);
    }

    @Test
    public void should06() throws Exception { //shouldFindByIdWithAddressCustomer
        Customer customer = customerDao.findByIdWithAddress(id);
        customerEquals(customer);
        AddressTest.addressEquals(customer.getAddress());
    }

    @Test
    public void should07() throws Exception { //shouldFindByLogin
        Customer customer = customerDao.findByLogin(CustomerTest.LOGIN);

        CustomerTest.customerEquals(customer);
    }

    @Test
    public void should08() throws Exception { //shouldRemoveCustomer
        Customer customer = customerDao.findById(id);
        assertNotNull(customer);

        customerDao.remove(customer);
        assertNull(customer.getId());

        customer = customerDao.findById(id);
        assertNull(customer);
    }

    @Test()
    public void should09() throws Exception { //shouldErrorValidationNotNull
        Customer customer = new Customer();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        int amount = amountConstraintViolation(validator.validate(customer), javax.validation.constraints.NotNull.class);
        assertEquals(amount, ANNOTATIONS_NOTNULL);
    }

    @Test()
    public void should10() throws Exception { //shouldErrorValidationNotEmpty
        Customer customer = createCustomer();

        customer.setPassword("");
        customer.setFirstName("");
        customer.setLastName("");
        customer.setPhone("");
        customer.setEmail("");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        int amount = amountConstraintViolation(validator.validate(customer), org.hibernate.validator.constraints.NotEmpty.class);
        assertEquals(amount, ANNOTATIONS_NOTEMPTY);
    }

    @Test()
    public void should11() throws Exception { //shouldErrorValidationMinSize
        Customer customer = createCustomer();

        customer.setLogin(fillString(Sizes.UserInfo.MIN_LOGIN - 1, 'a'));

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        int amount = amountConstraintViolation(validator.validate(customer), javax.validation.constraints.Size.class);
        assertEquals(amount, ANNOTATIONS_MIN_SIZE);
    }

    @Test()
    public void should12() throws Exception { //shouldErrorValidationMaxSize
        Customer customer = createCustomer();

        customer.setLogin(fillString(Sizes.UserInfo.MAX_LOGIN + 1, 'a'));
        customer.setPassword(fillString(Sizes.UserInfo.MAX_PASSWORD_HASH + 1, 'a'));
        customer.setFirstName(fillString(Sizes.UserInfo.MAX_FIRST_NAME + 1, 'a'));
        customer.setLastName(fillString(Sizes.UserInfo.MAX_LAST_NAME + 1, 'a'));
        customer.setPhone(fillString(Sizes.UserInfo.MAX_PHONE + 1, '1'));
        customer.setEmail(fillString(Sizes.UserInfo.MAX_EMAIL, 'a') + EMAIL);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        int amount = amountConstraintViolation(validator.validate(customer), javax.validation.constraints.Size.class);
        assertEquals(amount, ANNOTATIONS_MAX_SIZE);
    }
}
