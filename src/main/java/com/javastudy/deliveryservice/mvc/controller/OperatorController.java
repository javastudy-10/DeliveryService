package com.javastudy.deliveryservice.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Maxim Sambulat
 */
@Controller
//@RequestMapping(value = "/operator")
public class OperatorController {
    private static final String OPERATOR_FORM_JSP = "/operator/main";

    @RequestMapping(value = "/operator", method = {RequestMethod.GET, RequestMethod.POST})
    public String main() {
        return OPERATOR_FORM_JSP;
    }
}
