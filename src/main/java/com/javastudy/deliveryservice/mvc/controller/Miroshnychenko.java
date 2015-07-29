package com.javastudy.deliveryservice.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Oleksii Miroshychenko
 */
@Controller
public class Miroshnychenko {

    @RequestMapping(method = RequestMethod.GET, value = "/miroshnychenko.htm")
    public String getPage() {
        return "miroshnychenko";
    }
}

    

