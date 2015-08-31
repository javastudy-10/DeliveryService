package com.javastudy.deliveryservice.mvc.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Maxim Sambulat on 01.08.2015.
 */
public class ModelChangeEmail implements Passwording {
    private String currentEmail;

    @Size(min = 5, max = 64, message = "{email.size}")
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message = "{email.pattern}")
    private String newEmail;

    @Size(min = 6, max = 16, message = "{password.size}")
    @Pattern(regexp = "^[-+*/|\\\\ @#$%^&(){}?!,.:;`~_'\\\"<>a-zA-Z0-9]+$", message = "{password.pattern}")
    private String password;

    public ModelChangeEmail() {
    }

    public ModelChangeEmail(String currentEmail) {
        this.currentEmail = currentEmail;
    }

    public String getCurrentEmail() {
        return currentEmail;
    }

    public void setCurrentEmail(String currentEmail) {
        this.currentEmail = currentEmail;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
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
