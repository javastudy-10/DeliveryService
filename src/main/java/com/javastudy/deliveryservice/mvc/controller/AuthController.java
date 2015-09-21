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

    @RequestMapping(value = "/client/auth", method = {RequestMethod.GET})
    public String authClient() {
        return AUTH_CLIENT_FORM_JSP;
    }
}
