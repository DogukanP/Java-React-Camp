package com.padel.Entities;

import com.padel.Abstract.CustomerService;

import java.util.Date;

public class Customer implements CustomerService {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String nationalId;

    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, Date birthDate, String nationalId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.nationalId = nationalId;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }


    @Override
    public void save(Customer customer) {

    }
}