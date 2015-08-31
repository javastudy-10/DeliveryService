package com.javastudy.deliveryservice.mvc.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Maxim Sambulat on 01.08.2015.
 */
public class ModelChangePassword implements Passwording {

    @Size(min = 6, max = 16, message = "{password.size}")
    @Pattern(regexp = "^[-+*/|\\\\ @#$%^&(){}?!,.:;`~_'\\\"<>a-zA-Z0-9]+$", message = "{password.pattern}")
    private String password;

    @Size(min = 6, max = 16, message = "{password.size}")
    @Pattern(regexp = "^[-+*/|\\\\ @#$%^&(){}?!,.:;`~_'\\\"<>a-zA-Z0-9]+$", message = "{password.pattern}")
    private String newPassword;

    @Size(min = 6, max = 16, message = "{password.size}")
    @Pattern(regexp = "^[-+*/|\\\\ @#$%^&(){}?!,.:;`~_'\\\"<>a-zA-Z0-9]+$", message = "{password.pattern}")
    private String confirmPassword;

    public ModelChangePassword() {
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
