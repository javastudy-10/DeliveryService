package com.javastudy.deliveryservice.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Tarasenko {

    @RequestMapping(method = RequestMethod.GET, value = "/tarasenko.htm")
    public String getPage() {
        return "tarasenko";
    }
}
