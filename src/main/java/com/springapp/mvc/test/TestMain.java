package com.springapp.mvc.test;

/**
 * @auther f4o823hv9
 * @since  2017/3/21.
 */
public class TestMain {

    public static void main(String[] args) {

        EnumTest img = null;
        try {
            img = EnumTest.valueOf(EnumTest.class,"fdsfd");
        } catch (IllegalArgumentException e) {
            img = EnumTest.valueOf("OTHERS");
        }

        String value = img.getValue();
    }
}
