package com.springapp.mvc.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnumTestTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetEnum() {

        EnumTest img = null;
        try {
            //如果获取不到"fdsfd",那么就取ohers
            img = EnumTest.valueOf(EnumTest.class,"fdsfd");
        } catch (IllegalArgumentException e) {
            img = EnumTest.valueOf("OTHERS");
        }

        String value = img.getValue();
    }
}