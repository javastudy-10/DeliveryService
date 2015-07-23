package com.javastudy.deliveryservice.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Admin on 23.07.2015.
 */
@Controller
public class Sambulat {
    @RequestMapping(method = {RequestMethod.GET})
    public String getPage() {
        return "sambulat";
    }
}
