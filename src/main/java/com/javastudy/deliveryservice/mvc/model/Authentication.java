package com.javastudy.deliveryservice.mvc.model;

import com.javastudy.deliveryservice.validation.Patterns;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Maxim Sambulat
 */

public class Authentication {
    @NotNull(message = "{login.notnull}")
    @Size(min = 6, max = 16, message = "{login.size}")
    @Pattern(regexp = Patterns.LOGIN, message = "{login.pattern}")
    private String login;

    @NotNull(message = "{password.notnull}")
    @Size(min = 6, max = 16, message = "{password.size}")
    private String password;

    public Authentication() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
