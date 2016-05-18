package com.senapathi.retrofitdemo;

/**
 * Created by Senapathi on 18-05-2016.
 */
public class MyPojo
{
    private Contacts[] contacts;

    public Contacts[] getContacts ()
    {
        return contacts;
    }

    public void setContacts (Contacts[] contacts)
    {
        this.contacts = contacts;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [contacts = "+contacts+"]";
    }
}
