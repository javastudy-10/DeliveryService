package com.javastady.deliveryservice.test;

import com.javastudy.deliveryservice.mvc.dao.AddressDao;
import com.javastudy.deliveryservice.mvc.entity.Address;
import com.javastudy.deliveryservice.validation.Sizes;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static com.javastady.deliveryservice.test.Util.fillString;
import static com.javastady.deliveryservice.test.Util.printConstraintViolation;
import static org.junit.Assert.*;


/**
 * Created by Maxim Sambulat
 */
public class AddressTest {
    public static final String REGION = "Киевская область";
    public static final String DISTRICT = "Подольский район";
    public static final String CITY = "Киев";
    public static final String STREET = "Кобзарський переулок";
    public static final String HOUSE = "1";
    public static final String APARTMENT = "15";

    private static final int ANNOTATIONS_NOTNULL = 4;
    private static final int ANNOTATIONS_NOTEMPTY = 4;

    static AddressDao addressDao;
    private static Long id = 0L;

    public static Address createAddress() {
        Address address = new Address();
        address.setRegion(REGION);
        address.setDistrict(DISTRICT);
        address.setCity(CITY);
        address.setStreet(STREET);
        address.setHouse(HOUSE);
        address.setApartment(APARTMENT);

        return address;
    }


    public static void addressEquals(Address address) {
        assertNotNull(address);
        assertEquals(REGION, address.getRegion());
        assertEquals(DISTRICT, address.getDistrict());
        assertEquals(CITY, address.getCity());
        assertEquals(STREET, address.getStreet());
        assertEquals(HOUSE, address.getHouse());
        assertEquals(APARTMENT, address.getApartment());
    }

    @BeforeClass
    public static void initDao() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextTest.xml");
        addressDao = ctx.getBean(AddressDao.class);
    }

    @Test
    public void should1() throws Exception { //shouldNotFindAddress
        Address address = addressDao.findByID(100L);
        assertNull(address);
    }

    @Test
    public void should2() throws Exception { //shouldPersistenceAddress
        Address address = createAddress();

        addressDao.persist(address);

        assertNotNull(address.getId());
        id = address.getId();
    }

    @Test
    public void should3() throws Exception { //shouldFindByIdAddress
        Address address = addressDao.findByID(id);
        addressEquals(address);
    }

    @Test
    public void should4() throws Exception { //shouldRemoveAddress
        Address address = addressDao.findByID(id);
        assertNotNull(address);

        addressDao.remove(address);
        assertNull(address.getId());

        address = addressDao.findByID(id);
        assertNull(address);
    }

    @Test(expected = javax.persistence.PersistenceException.class)
    public void should5() throws Exception { //shouldErrorDuplicate
        Address address = createAddress();
        addressDao.persist(address);

        Address addressDuplicate = createAddress();
        addressDao.persist(addressDuplicate);
    }

    @Test()
    public void should6() throws Exception { //shouldErrorValidationNotNullAndNotEmpty
        Address address = new Address();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        printConstraintViolation(validator.validate(address));
        assertEquals(validator.validate(address).size(), ANNOTATIONS_NOTNULL + ANNOTATIONS_NOTEMPTY);
    }

    @Test()
    public void should7() throws Exception { //shouldErrorValidationNotEmpty
        Address address = createAddress();
        address.setRegion("");
        address.setCity("");
        address.setStreet("");
        address.setHouse("");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        assertEquals(validator.validate(address).size(), ANNOTATIONS_NOTEMPTY);
    }

    @Test()
    public void should8() throws Exception { //shouldErrorValidationMax
        Address address = new Address();
        address.setRegion(fillString(Sizes.Address.MAX_REGION + 1, '*'));
        address.setDistrict(fillString(Sizes.Address.MAX_DISTRICT + 1, '*'));
        address.setCity(fillString(Sizes.Address.MAX_CITY + 1, '*'));
        address.setStreet(fillString(Sizes.Address.MAX_STREET + 1, '*'));
        address.setHouse(fillString(Sizes.Address.MAX_HOUSE + 1, '*'));
        address.setApartment(fillString(Sizes.Address.MAX_APARTMENT + 1, '*'));

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        assertEquals(validator.validate(address).size(), 6);

    }
}
