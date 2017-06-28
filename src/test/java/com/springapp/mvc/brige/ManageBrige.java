package com.springapp.mvc.brige;

/**
 * @author f4o823hv9
 * @since 2017/4/4.
 */
public class ManageBrige {
    private SourceAble source;

    public void handMethod(){
        source.method();
    }

    public SourceAble getSource() {
        return source;
    }

    public void setSource(SourceAble source) {
        this.source = source;
    }
}
