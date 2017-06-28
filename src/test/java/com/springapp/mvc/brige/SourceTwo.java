package com.springapp.mvc.brige;

/**
 * 桥接模式，实现类2
 *
 * @author f4o823hv9
 * @since 2017/4/4.
 */
public class SourceTwo implements SourceAble{

    @Override
    public void method() {
        System.out.println("桥接模式，实现类2");
    }
}
