package com.springapp.mvc.test;

/**
 * @auther f4o823hv9
 * @since  2017/3/21.
 */
public enum EnumTest {
    IMG("Img","777"), APK("apk","111"), OTHERS("others","711");
    private String value;
    private String key;


    private EnumTest(String key,String value)
    {
        this.value = value;
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }
    public String getValue(){
        return this.value;
    }
}
