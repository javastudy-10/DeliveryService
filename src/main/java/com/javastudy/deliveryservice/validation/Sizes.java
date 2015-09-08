package com.javastudy.deliveryservice.validation;

/**
 * Created by Maxim Sambulat
 */
public final class Sizes {
    public static final class Address {
        public static final int MAX_REGION = 32;
        public static final int MAX_DISTRICT = 32;
        public static final int MAX_CITY = 32;
        public static final int MAX_STREET = 32;
        public static final int MAX_HOUSE = 8;
        public static final int MAX_APARTMENT = 8;

        private Address() {
        }
    }

    public static final class UserInfo {
        public static final int MIN_LOGIN = 6;
        public static final int MAX_LOGIN = 16;
        public static final int MAX_PASSWORD_HASH = 64;
        public static final int MAX_FIRST_NAME = 32;
        public static final int MAX_LAST_NAME = 32;
        public static final int MAX_PHONE = 20;
        public static final int MAX_EMAIL = 64;

        private UserInfo() {
        }
    }

    private Sizes() {
    }
}
