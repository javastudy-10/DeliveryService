package com.javastudy.deliveryservice.mvc.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Maxim Sambulat on 01.08.2015.
 */
public class ModelChangeAddress implements Passwording {
    private String currentAddress;

    @Size(min=4, max=128, message="{address.size}")
    @Pattern(regexp="^[a-zA-Zа-яА-Я0-9.,/ ]+$", message="{address.pattern}")
    private String newAddress;

    @Size(min=6, max=16, message="{password.size}")
    @Pattern(regexp="^[-+*/|\\\\ @#$%^&(){}?!,.:;`~_'\\\"<>a-zA-Z0-9]+$", message="{password.pattern}")
    private String password;

    public ModelChangeAddress() {
    }

    public ModelChangeAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(String newAddress) {
        this.newAddress = newAddress;
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
