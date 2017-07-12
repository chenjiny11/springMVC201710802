package com.springapp.mvc.test;

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:mvc-dispatcher-servlet.xml")
public class JsoupUtilTest {

    @Autowired
    private JsoupUtil jsoupUtil;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testHttpGet () {
        jsoupUtil.get("http://sj.qq.com/myapp/searchAjax.htm?kw=gaode&pns=&sid=");
    }

    @Test
    public void testAjaxGet () {
        jsoupUtil.get("http://sj.qq.com/myapp/searchAjax.htm?kw=gaode&pns=&sid=", true);
    }
    
    @Test
    public void testPost() {
        String postResult = jsoupUtil.post("http://sj.qq.com/myapp/searchAjax.htm?kw=gaode&pns=&sid=");
        JSONObject jsonObject = (JSONObject) JSONObject.parse(postResult);
        System.out.println(jsonObject);

    }
}