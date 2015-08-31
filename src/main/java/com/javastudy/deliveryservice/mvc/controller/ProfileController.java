package com.javastudy.deliveryservice.mvc.controller;

import com.javastudy.deliveryservice.mvc.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by Maxim Sambulat
 */
@Controller
@RequestMapping(value = "/client")
public class ProfileController {
    public static String mLogin = "Иванов";
    public static String mAddress = "Kiev, Khreshchatyk, 1";
    public static String mEmail = "example@example.com";
    public static String mPhone = "+38(099)568-12-23";
    public static String mPassword = "";

    private static final String REDIRECT_PROFILE_FORM = "redirect:/client/profile";
    private static final String PROFILE_FORM_JSP = "client/profile/main";
    private static final String EDIT_ADDRESS_JSP = "client/profile/edit-address";
    private static final String EDIT_EMAIL_JSP = "client/profile/edit-email";
    private static final String EDIT_PHONE_JSP = "client/profile/edit-phone";
    private static final String EDIT_PASSWORD_JSP = "client/profile/edit-password";

    @Autowired
    MessageSource messageSource;

    private void checkPassword(BindingResult bindingResult, String modelName, Passwording password) {
        if (bindingResult.getFieldErrorCount("password") == 0) {
            //TODO Calc password hash-code and compare
            boolean valid = password.getPassword().equals("12345678");

            if (!valid) {
                Locale locale = LocaleContextHolder.getLocale();
                String msg = messageSource.getMessage("password.incorrect", new Object[]{}, locale);
                bindingResult.addError(new FieldError(modelName, "password", msg));
            }
        }
    }

    @RequestMapping(value = "/profile", method = {RequestMethod.GET, RequestMethod.POST})
    public String main(ModelMap model) {
        model.addAttribute("profinfo", new ProfileInfo(mLogin, mAddress, mEmail, mPhone));
        return PROFILE_FORM_JSP;
    }

    @PreAuthorize("isAuthenticated() && (hasRole('ROLE_CLIENT') || hasRole('ROLE_ADMIN'))")
    @RequestMapping(value = "/profile/edit/address", method = RequestMethod.POST)
    public String editAddress(ModelMap model) {
        //TODO Load address to model
        model.addAttribute("address", new ModelChangeAddress(mAddress));

        return EDIT_ADDRESS_JSP;
    }


    @RequestMapping(value = "/profile/change/address", method = RequestMethod.POST)
    public String changeAddress(@Valid @ModelAttribute("address") ModelChangeAddress address, BindingResult bindingResult) {
        checkPassword(bindingResult, "address", address);

        if (bindingResult.hasErrors()) {
            address.setPassword("");
            return EDIT_ADDRESS_JSP;
        }

        //TODO Save new address
        mAddress = address.getNewAddress();

        return REDIRECT_PROFILE_FORM;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/profile/edit/email", method = RequestMethod.POST)
    public String editEmail(ModelMap model) {
        //TODO Load email to model
        model.addAttribute("email", new ModelChangeEmail(mEmail));

        return EDIT_EMAIL_JSP;
    }


    @RequestMapping(value = "/profile/change/email", method = RequestMethod.POST)
    public String changeAddress(@Valid @ModelAttribute("email") ModelChangeEmail email, BindingResult bindingResult) {
        checkPassword(bindingResult, "email", email);

        if (bindingResult.hasErrors()) {
            email.setPassword("");
            return EDIT_EMAIL_JSP;
        }

        //TODO Save new email
        mEmail = email.getNewEmail();

        return REDIRECT_PROFILE_FORM;
    }


    @RequestMapping(value = "/profile/edit/phone", method = RequestMethod.POST)
    public String editPhone(ModelMap model) {
        //TODO Load phone to model
        model.addAttribute("phone", new ModelChangePhone(mPhone));

        return EDIT_PHONE_JSP;
    }


    @RequestMapping(value = "/profile/change/phone", method = RequestMethod.POST)
    public String changePhone(@Valid @ModelAttribute("phone") ModelChangePhone phone, BindingResult bindingResult) {
        checkPassword(bindingResult, "phone", phone);

        if (bindingResult.hasErrors()) {
            phone.setPassword("");
            return EDIT_PHONE_JSP;
        }

        //TODO Save new phone
        mPhone = phone.getNewPhone();

        return REDIRECT_PROFILE_FORM;
    }


    @RequestMapping(value = "/profile/edit/password", method = RequestMethod.POST)
    public String editPassword(ModelMap model) {
        //TODO Load password to model
        model.addAttribute("password", new ModelChangePassword());

        return EDIT_PASSWORD_JSP;
    }


    @RequestMapping(value = "/profile/change/password", method = RequestMethod.POST)
    public String changePassword(@Valid @ModelAttribute("password") ModelChangePassword password, BindingResult bindingResult) {
        checkPassword(bindingResult, "password", password);

        if (bindingResult.hasErrors()) {
            password.setPassword("");
            return EDIT_PASSWORD_JSP;
        }

        //TODO Save new password
        mPassword = password.getNewPassword();

        return REDIRECT_PROFILE_FORM;
    }
}
