package com.songo;

import java.io.Serializable;

/**
 * Created By GS 11:15 2020/4/11
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -4824231695984697752L;
    private String id;
    private String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
