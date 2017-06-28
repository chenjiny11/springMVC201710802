package com.springapp.mvc;

import org.junit.Before;
import org.junit.Test;
import org.powermock.core.PowerMockUtils;
import org.powermock.modules.junit4.internal.impl.testcaseworkaround.PowerMockJUnit4MethodValidator;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.*;

//import static org.mockito.Mockito.*;
//import static org.junit.Assert.*;

public class HelloControllerTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testPrintWelcome() throws Exception {
//        RequestBuilder getRequest = MockMvcRequestBuilders.get("/printWelcome");
        TestSerial aa = new TestSerial();
        aa.setName("test");
        TestSerial bb = (TestSerial) aa.clones();
        System.out.println(bb.getName());
        aa.setName("change");
        System.out.println(aa.getName());
        System.out.println(bb.getName());
    }

}