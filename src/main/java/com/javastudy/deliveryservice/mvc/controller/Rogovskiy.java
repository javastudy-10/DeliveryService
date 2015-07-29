package com.javastudy.deliveryservice.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by DENIS on 23.07.2015.
 */
@Controller
public class Rogovskiy {
    @RequestMapping(method = RequestMethod.GET, value = "/rogovskiy.htm")
    public String getPage() {
        return "rogovskiy";
    }
}
