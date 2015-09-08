package com.javastady.deliveryservice.test;

import javax.validation.ConstraintViolation;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by Maxim Sambulat
 */
class Util {
    public static String fillString(int length, char symbol) {
        char[] array = new char[length];
        Arrays.fill(array, symbol);
        return new String(array);
    }

    public static <T> int amountConstraintViolation(Set<ConstraintViolation<T>> constraintViolations, Class<?> annotation) {
        int result = 0;
        String annotationName = annotation.getName();

        for (ConstraintViolation cv : constraintViolations) {
            if (cv.getConstraintDescriptor().getAnnotation().toString().startsWith(annotationName, 1)) {
                ++result;
            }
        }

        return result;
    }

    public static <T> void printConstraintViolation(Set<ConstraintViolation<T>> constraintViolations) {
        for (ConstraintViolation cv : constraintViolations) {
            System.out.println(padRight("ConstraintDescriptor Annotation: ", 33) + cv.getConstraintDescriptor().getAnnotation());
            System.out.println(padRight("ConstraintDescriptor:", 33) + cv.getConstraintDescriptor());
            System.out.println(padRight("MessageTemplate:", 33) + cv.getMessageTemplate());
            System.out.println(padRight("InvalidValue:", 33) + cv.getInvalidValue());
            System.out.println(padRight("LeafBean:", 33) + cv.getLeafBean());
            System.out.println(padRight("RootBeanClass:", 33) + cv.getRootBeanClass());
            System.out.println(padRight("PropertyPath:", 33) + cv.getPropertyPath().toString());
            System.out.println(padRight("Message:", 33) + cv.getMessage());
        }
    }

    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }
}
