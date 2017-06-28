package com.springapp.mvc.brige;

/**
 * 桥接模式，具体实现类1
 *
 * @author f4o823hv9
 * @since 2017/4/4.
 */
public class SourceOne implements SourceAble {

    @Override
    public void method() {
        System.out.println("桥接模式，实现方法1");
    }
}
