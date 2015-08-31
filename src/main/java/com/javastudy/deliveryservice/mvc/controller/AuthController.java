package com.javastudy.deliveryservice.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Maxim Sambulat
 */
@Controller
public class AuthController {
    private static final String AUTH_CLIENT_FORM_JSP = "client/auth/main";
    private static final String AUTH_OPERATOR_FORM_JSP = "operator/auth/main";

    @RequestMapping(value = "/client/auth", method = {RequestMethod.GET, RequestMethod.POST})
     public String authClient() {
        return AUTH_CLIENT_FORM_JSP;
    }

    @RequestMapping(value = "/operator/auth", method = {RequestMethod.GET, RequestMethod.POST})
    public String authOperator() {
        return AUTH_OPERATOR_FORM_JSP;
    }
}
