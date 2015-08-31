package com.javastudy.deliveryservice.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Maxim Sambulat
 */
@Controller
public class HomeController {
    private static final String HOME_FORM_JSP = "/home";

    @RequestMapping(value = "/home", method = {RequestMethod.GET, RequestMethod.POST})
    public String main() {
        return HOME_FORM_JSP;
    }
}
