package com.springapp.mvc;

import java.io.*;

/**
 * Created by f4o823hv9 on 2017/4/2.
 */
public class TestSerial implements Serializable,Cloneable {
    private final static long serialVersionUID = 1L;
    public  String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object clones()  throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }
}
