package com.javastudy.deliveryservice.security;

import com.javastudy.deliveryservice.domain.UserRole;

import java.util.Set;

/**
 * Created by Maxim Sambulat
 */
public interface Authentication {
    String getLogin();

    String getPassword();

    boolean isEnabled();
}
