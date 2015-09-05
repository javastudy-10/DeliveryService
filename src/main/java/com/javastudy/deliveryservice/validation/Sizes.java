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

    private Sizes() {
    }
}
