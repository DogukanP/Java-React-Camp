package com.padel.Entities;

import com.padel.Abstract.Entity;
import com.padel.Concrete.CustomerManager;

public class Customer extends User{
    private String firstName;
    private String lastName;
    private int age;
    private String nationalId;

    public Customer(String firstName, String lastName, int age, String nationalId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationalId = nationalId;
    }

    public Customer(int id, String email, String firstName, String lastName, int age, String nationalId) {
        super(id, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationalId = nationalId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }
}