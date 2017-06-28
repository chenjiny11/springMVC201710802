package com.springapp.mvc;

import com.springapp.mvc.brige.ManageBrige;
import com.springapp.mvc.brige.SourceAble;
import com.springapp.mvc.brige.SourceOne;
import com.springapp.mvc.brige.SourceTwo;
import org.junit.Test;

/**
 * 测试方法
 *
 * @author f4o823hv9
 * @since  2017/4/4.
 */
public class TestClass {

    @Test
    public void testBrige(){
        SourceAble sourceOne = new SourceTwo();
        ManageBrige manageBrige = new ManageBrige();
        manageBrige.setSource(sourceOne);
        manageBrige.handMethod();
    }

    @Test
    public void testOthers() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        SourceAble sourceOne = new SourceOne();
        Class manageBrige = Class.forName("com.springapp.mvc.brige.ManageBrige");
        ManageBrige manageBrige1 = (ManageBrige) manageBrige.newInstance();
        manageBrige1.setSource(sourceOne);
        manageBrige1.handMethod();

    }
}
