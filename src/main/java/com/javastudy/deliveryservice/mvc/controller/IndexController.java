package com.javastudy.deliveryservice.mvc.controller;

import com.javastudy.deliveryservice.mvc.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
@RequestMapping("/")
public class IndexController {

    @Inject
    private AddressService addressService;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome() {
//        Address address = new Address();
//        address.setId(1L);
//        address.setRegion("Луганская область");
//        address.setDistrict("Первомайский район");
//        address.setStreet("Харьковская");
//        address.setHouse("7");
//        address.setApartment("17");

//
//        addressService.save(address);
//
//        List<Address> addresses = addressService.findAll();
//        for (Address item: addresses) {
//            System.out.println(item);
//        }
        return "index";
    }
}
