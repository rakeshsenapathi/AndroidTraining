package com.senapathi.retrofitdemo;

public class Contacts
{
    private String id;

    private String address;

    private String email;

    private String name;

    private String gender;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }



    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getGender ()
    {
        return gender;
    }

    public void setGender (String gender)
    {
        this.gender = gender;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", address = "+address+", email = "+email+", name = "+name+", gender = "+gender+"]";
    }
}

