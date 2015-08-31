package com.javastudy.deliveryservice.test;

import com.javastudy.deliveryservice.mvc.dao.AddressDao;
import com.javastudy.deliveryservice.mvc.entity.Address;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by Maxim Sambulat
 */
public class AddressTest {
    public static final String REGION = "Киевская область";
    public static final String DISTRICT = "Подольский район";
    public static final String CITY = "Киев";
    public static final String STREET = "Кобзарський";
    public static final String HOUSE = "1";
    public static final String APARTMENT = "15";

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
    public void shouldNotFindAddress() throws Exception {
        Address address = addressDao.findByID(100L);
        assertNull(address);
    }

    @Test
    public void should1() throws Exception { //shouldPersistenceAddress
        Address address = createAddress();

        addressDao.persist(address);

        assertNotNull(address.getId());
        id = address.getId();
    }

    @Test
    public void should2() throws Exception { //shouldFindByIdAddress
        Address address = addressDao.findByID(id);
        addressEquals(address);
//        assertNotNull(address);
//        assertEquals(REGION, address.getRegion());
//        assertEquals(DISTRICT, address.getDistrict());
//        assertEquals(CITY, address.getCity());
//        assertEquals(STREET, address.getStreet());
//        assertEquals(HOUSE, address.getHouse());
//        assertEquals(APARTMENT, address.getApartment());
    }
}
