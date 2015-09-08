package com.javastudy.deliveryservice.validation;

/**
 * Created by Maxim Sambulat
 */
public final class Patterns {
    public static final String LOGIN = "^[a-zA-Zа-яА-Я'\"`]+$";
    public static final String NAME = "^[a-zA-Zа-яА-Я'`]+$";
    public static final String PHONE = "^[-+()0-9]+$";

    private Patterns() {}
}
