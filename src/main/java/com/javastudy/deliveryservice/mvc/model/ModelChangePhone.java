package com.javastudy.deliveryservice.mvc.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Maxim Sambulat on 01.08.2015.
 */
public class ModelChangePhone implements Passwording {
    private String currentPhone;

    @Size(min = 4, max = 16, message = "{phone.size}")
    @Pattern(regexp = "^[-+()0-9]+$", message = "{phone.pattern}")
    private String newPhone;

    @Size(min = 6, max = 16, message = "{password.size}")
    @Pattern(regexp = "^[-+*/|\\\\ @#$%^&(){}?!,.:;`~_'\\\"<>a-zA-Z0-9]+$", message = "{password.pattern}")
    private String password;

    public ModelChangePhone() {
    }

    public ModelChangePhone(String currentPhone) {
        this.currentPhone = currentPhone;
    }

    public String getCurrentPhone() {
        return currentPhone;
    }

    public void setCurrentPhone(String currentPhone) {
        this.currentPhone = currentPhone;
    }

    public String getNewPhone() {
        return newPhone;
    }

    public void setNewPhone(String newPhone) {
        this.newPhone = newPhone;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
