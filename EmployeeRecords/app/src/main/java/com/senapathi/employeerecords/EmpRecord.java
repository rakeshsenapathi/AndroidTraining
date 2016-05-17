package com.senapathi.employeerecords;

import java.io.Serializable;

/**
 * Created by Senapathi on 09-05-2016.
 */
public class EmpRecord implements Serializable {
    private String name;
    private String designation;
    private String salary;


    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public EmpRecord() {

    }

    public String name() {
        return name;
    }
}
