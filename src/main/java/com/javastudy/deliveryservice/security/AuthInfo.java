package com.javastudy.deliveryservice.security;

/**
 * Created by Maxim Sambulat
 */
public interface AuthInfo {
    String getLogin();

    String getPassword();

    boolean isEnabled();
}
