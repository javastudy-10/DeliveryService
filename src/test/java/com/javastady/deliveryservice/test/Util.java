package com.javastady.deliveryservice.test;

import java.util.Arrays;

/**
 * Created by Maxim Sambulat
 */
class Util {
    public static String fillString(int length, char symbol) {
        char[] array = new char[length];
        Arrays.fill(array, symbol);
        return new String(array);
    }
}
