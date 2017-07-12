package com.springapp.mvc.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImageCompareTest {
    private ImageCompare imageCompare;

    @Before
    public void setUp() throws Exception {
        imageCompare = new ImageCompare();
    }

    @Test
    public void testCompareImage() throws Exception {
        imageCompare.compareImage();
        System.out.println("over");
    }
}