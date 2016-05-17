package com.senapathi.apicallsdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Senapathi on 17-05-2016.
 */
public class MyClass  {

     private List<contacts> contact = new ArrayList<>();

    public List<contacts> getContact() {
        return contact;
    }

    public void setContact(List<contacts> contact) {
        this.contact = contact;
    }
}
